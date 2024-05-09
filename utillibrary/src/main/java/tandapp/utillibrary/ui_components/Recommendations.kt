package tandapp.utillibrary.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import tandapp.utillibrary.BuildConfig
import tandapp.utillibrary.ProductModel
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Silver3
import tandapp.utillibrary.values.fontSize10
import tandapp.utillibrary.values.fontSize8
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight13
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing20
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
        modifier = Modifier.padding(bottom = spacing64),
        horizontalArrangement = Arrangement.spacedBy(spacing12),
        verticalArrangement = Arrangement.spacedBy(spacing20),
        maxItemsInEachRow = 3
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
            .background(color = Color.White)
            .height(180.dp)
            .width(107.dp)
            .padding(horizontal = spacing4)
            .click{
                onClick(product?.id)
            }
    ) {
        Icon(
            painter = painterResource(id = tandapp.icons.R.drawable.ic_like),
            contentDescription = null,
            tint = Silver3,
            modifier = Modifier
                .size(22.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-6).dp, y = 10.dp)
                .zIndex(1f)
                .click {
                    onAddProductToBacket(product?.id)
                }
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = spacing4)
        ) {
            AsyncImage(
                model = "http://91.147.105.187:9000/product/get_image/${product?.previewImage}",
                contentDescription = null,
                modifier = Modifier
                    .width(90.dp)
                    .height(120.dp)
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
                fontSize = fontSize10,
                lineHeight = lineHeight10
            )

            Spacer(modifier = Modifier.height(spacing8))


            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "${product?.price} ₸",
                    color = Color.Black,
                    fontSize = fontSize10,
                    lineHeight = lineHeight13
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