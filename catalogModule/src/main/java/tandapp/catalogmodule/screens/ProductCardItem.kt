package tandapp.catalogmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.getViewModel
import tandapp.catalogmodule.viewmodels.ProductCardViewModel
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.click
import tandapp.utillibrary.pagers.BannerPager
import tandapp.utillibrary.pagers.CardPager
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightIcon
import tandapp.utillibrary.values.Base100
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius12
import tandapp.utillibrary.values.cornerRadius4
import tandapp.utillibrary.values.cornerRadius8
import tandapp.utillibrary.values.fontSize10
import tandapp.utillibrary.values.fontSize13
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.fontSize18
import tandapp.utillibrary.values.fontSize20
import tandapp.utillibrary.values.lineHeight13
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.lineHeight28
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing40
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCardItem(
    id: Int,
    onBackClick: () -> Unit = {},
    viewModel: ProductCardViewModel = getViewModel()
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
    BackHandler {
        onBackClick()
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getProductInfo(id)
    }

    val product by viewModel.product
    Scaffold(
        topBar = {
            Column(modifier = Modifier.padding(spacing16)) {
                DefaultToolbarWithRightIcon(
                    onBackClick = onBackClick,
                    buttonText = "Назад",
//                    icon = tandapp.icons.R.drawable.ic_like
                )
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = spacing16, end = spacing16),
                horizontalArrangement = Arrangement.End,
            ) {

                if (product?.onBasket == true) {
                    OutlinedButton(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            backgroundColor = Color.White,
                        ),
                        modifier = Modifier
                            .width(140.dp)
                            .height(55.dp)
                            .clip(shape = RoundedCornerShape(cornerRadius12))
                            .background(
                                shape = RoundedCornerShape(cornerRadius12),
                                color = Color.White
                            )
                            .border(1.dp, Purple, RoundedCornerShape(cornerRadius12)),
                        content = {
                            CustomButtonText(
                                text = "Добавлено в корзину",
                                fontSize = fontSize16,
                                lineHeight = lineHeight18,
                                color = Purple
                            )
                        },
                        onClick = {
//                            viewModel.deleteProduct(id)
                        })
                } else {
                    CustomButton(
                        modifier = Modifier
                            .width(125.dp)
                            .height(55.dp),
                        cornerRadius = cornerRadius8,
                        content = {
                            CustomButtonText(
                                text = "В корзину",
                                fontSize = fontSize16,
                                lineHeight = lineHeight18
                            )
                        }) {
                        viewModel.addProductToBacket(id)

                    }
                }
            }
        },
        content = {
            it.calculateTopPadding()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = spacing8),
            ) {
                item {
                    Spacer(modifier = Modifier.height(spacing12))
                }
                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CardPager(
                            pagerState = pagerState,
                            iconWidth = 306.dp,
                            iconHeight = 306.dp,
                            image = "http://91.147.105.187:9000/product/get_image/${product?.previewImage}",
                        )
                    }

                    Spacer(modifier = Modifier.height(spacing16))
                    Divider()
                }
                item {
                    Spacer(modifier = Modifier.height(spacing24))
                }
                item {
                    Column(modifier = Modifier.padding(horizontal = spacing16)) {
                        Text(
                            text = product?.brand.orEmpty(),
                            style = TextStyle(
                                fontSize = fontSize20,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                            )
                        )
                        Spacer(modifier = Modifier.height(spacing8))
                        Text(
                            text = product?.title.orEmpty(),
                            style = TextStyle(
                                fontSize = fontSize18,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                            )
                        )
                        Spacer(modifier = Modifier.height(spacing8))
                        Text(
                            text = "Размер: ${viewModel.selectedSize.value}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight(400),
                                color = Color.Black,
                            )
                        )
                        Spacer(modifier = Modifier.height(spacing8))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(viewModel.shoesSizes.size) {
                                val selected =
                                    viewModel.selectedSize.value == viewModel.shoesSizes[it]
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(cornerRadius4))
                                        .background(
                                            if (selected)
                                                Purple else Base100
                                        )
                                        .padding(horizontal = spacing8, vertical = spacing2)
                                        .click {
                                            viewModel.selectedSize.value = viewModel.shoesSizes[it]
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = viewModel.shoesSizes.get(it),
                                        color = if (selected) Color.White else Color.Black,
                                        fontSize = fontSize14,
                                        lineHeight = lineHeight24,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Spacer(modifier = Modifier.width(spacing4))
                            }
                        }
                        Spacer(modifier = Modifier.height(spacing8))
                        Text(
                            text = "Цвет: ${viewModel.shoesColors.get(viewModel.selectedColor.value).title}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 18.sp,
                                fontWeight = FontWeight(400),
                                color = Color.Black,
                            )
                        )
                        Spacer(modifier = Modifier.height(spacing8))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(viewModel.shoesColors.size) {
                                val selected =
                                    viewModel.selectedColor.value == viewModel.shoesColors[it].id
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(cornerRadius8))
                                        .border(
                                            1.dp, color = if (selected) Purple else Silver4,
                                            shape = RoundedCornerShape(cornerRadius8)
                                        )
                                        .background(
                                            viewModel.shoesColors[it].color,
                                        )
                                        .click {
                                            viewModel.selectedColor.value =
                                                viewModel.shoesColors[it].id
                                        },
                                    contentAlignment = Alignment.Center
                                ) {

                                }
                                Spacer(modifier = Modifier.width(spacing4))
                            }
                        }
                    }
                }

                item {
                    Column(modifier = Modifier.padding(horizontal = spacing16)) {
                        Spacer(modifier = Modifier.height(spacing16))

                        Text(
                            text = "Описание",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            fontSize = fontSize18,
                            lineHeight = lineHeight24
                        )

                        Spacer(modifier = Modifier.height(spacing8))

                        Text(
                            text = product?.description.orEmpty(),
                            style = TextStyle(
                                fontSize = fontSize13,
                                lineHeight = lineHeight18,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(spacing24))

                    Text(
                        text = "Цена: ${product?.price} ₸",
                        fontSize = fontSize20,
                        lineHeight = lineHeight28,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = spacing16)
                    )
                }
            }
        }
    )
}