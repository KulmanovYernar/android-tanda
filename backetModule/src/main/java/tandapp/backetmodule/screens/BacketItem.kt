package tandapp.backetmodule.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tandapp.utillibrary.ProductModel
import tandapp.utillibrary.click
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius12
import tandapp.utillibrary.values.cornerRadius20
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.lineHeight10
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@Composable
fun BacketItem(
    product: ProductModel?,
    onDeleteProduct: () -> Unit = {},
    onAddClick: () -> Unit = {},
    onDecreaseClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(cornerRadius12))
            .border(1.dp, Silver4, shape = RoundedCornerShape(cornerRadius12))
            .padding(vertical = spacing4, horizontal = spacing4)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(spacing16))
            AsyncImage(
                model = "http://91.147.105.187:9000/product/get_image/${product?.previewImage}",
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(153.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(spacing40))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = spacing8)
            ) {
                Text(
                    text = "${product?.title} ${product?.brand}",
                    style = TextStyle(
                        fontSize = fontSize13,
                        lineHeight = lineHeight10,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(spacing2))

                Text(
                    text = "Цвет: ${product?.color}",
                    style = TextStyle(
                        fontSize = fontSize13,
                        lineHeight = lineHeight10,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(spacing2))

                Text(
                    text = "Размер: ${product?.size}",
                    style = TextStyle(
                        fontSize = fontSize13,
                        lineHeight = lineHeight10,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )


                Spacer(modifier = Modifier.height(spacing8))

                Text(
                    text = "Цена: ${product?.price} ₸",
                    style = TextStyle(
                        fontSize = fontSize13,
                        lineHeight = lineHeight10,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )


            }
        }
        Spacer(modifier = Modifier.height(spacing2))

        Divider()

        Spacer(modifier = Modifier.height(spacing2))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing16),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            OutlinedButton(
                onClick = {
                    onDeleteProduct()
                },
            ) {
                Text(
                    text = "Удалить",
                    color = Color.Red,
                    fontSize = fontSize13
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(cornerRadius20))
                        .background(Color.White)
                        .border(
                            1.dp, Purple, shape = RoundedCornerShape(
                                cornerRadius20
                            )
                        )
                        .click {
                            if(product?.quantity == 1){
                                onDeleteProduct()
                            }else {
                                onDecreaseClick()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "-",
                        textAlign = TextAlign.Center,
                        color = Purple,
                        fontSize = fontSize18,
                    )
                }
                Spacer(modifier = Modifier.width(spacing8))
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "${product?.quantity}",
                        style = TextStyle(
                            fontSize = fontSize16,
                            lineHeight = lineHeight22,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                        )
                    )
                }
                Spacer(modifier = Modifier.width(spacing8))
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(cornerRadius20))
                        .background(Purple)
                        .border(
                            1.dp, Purple, shape = RoundedCornerShape(
                                cornerRadius20
                            )
                        )
                        .click {
                            onAddClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = fontSize18,
                    )
                }
            }
        }
    }
}