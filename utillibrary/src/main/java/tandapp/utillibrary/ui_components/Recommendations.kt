package tandapp.utillibrary.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tandapp.utillibrary.ProductModel
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Silver2
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing64
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Recommendations(
    products: List<ProductModel>? = null,
    onClick: (id: Int?) -> Unit = {},
    onAddProductToBacket: (id: Int?) -> Unit = {},
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Silver2.copy(alpha = 0.8f))
            .padding(bottom = spacing64),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(spacing16),
        maxItemsInEachRow = 2
    ) {
        repeat(products?.size ?: 0) {
            RecommendationItem(
                onClick = onClick,
                onAddProductToBacket = onAddProductToBacket,
                product = products?.get(it)
            )
        }
    }
}

@Composable
private fun RecommendationItem(
    product: ProductModel? = null,
    onClick: (id: Int?) -> Unit,
    onAddProductToBacket: (id: Int?) -> Unit,
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(175.dp)
            .background(color = Color.White)
            .padding(horizontal = spacing4)
            .click {
                onClick(product?.id)
            }
    ) {
//        Icon(
//            painter = painterResource(id = tandapp.icons.R.drawable.ic_like),
//            contentDescription = null,
//            tint = Silver3,
//            modifier = Modifier
//                .size(22.dp)
//                .align(Alignment.TopEnd)
//                .offset(x = (-6).dp, y = 10.dp)
//                .zIndex(1f)
//                .click {
//                    onAddProductToBacket(product?.id)
//                }
//        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = spacing4)
        ) {
            AsyncImage(
                model = "http://91.147.105.187:9000/product/get_image/${product?.previewImage}",
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp),
                contentScale = ContentScale.FillWidth
            )
//            Image(
//                painter = painterResource(id = tandapp.icons.R.drawable.img_sneakers),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(90.dp)
//                    .height(120.dp)
//            )

            Spacer(modifier = Modifier.height(spacing4))

            Text(
                text = product?.brand.orEmpty() + " " + product?.title.orEmpty(),
                color = Color.Black,
                fontSize = fontSize13,
                lineHeight = lineHeight18,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(spacing8))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${product?.price} ₸",
                    color = Color.Black,
                    fontSize = fontSize13,
                    lineHeight = lineHeight18,
                    fontWeight = FontWeight.Medium,
                )
//                Spacer(modifier = Modifier.width(spacing4))
//                Text(
//                    text = "49 990 ₸",
//                    color = Silver3,
//                    fontSize = fontSize8,
//                    lineHeight = lineHeight13,
//                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
//                )
            }
        }
    }
}