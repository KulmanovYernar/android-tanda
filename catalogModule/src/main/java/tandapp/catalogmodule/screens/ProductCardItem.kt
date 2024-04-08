package tandapp.catalogmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import tandapp.utillibrary.click
import tandapp.utillibrary.pagers.BannerPager
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightIcon
import tandapp.utillibrary.values.Base100
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.cornerRadius4
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.lineHeight24
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCardItem(
    onBackClick: () -> Unit = {},
    viewModel: ProductCardViewModel = getViewModel()
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 6 })
    BackHandler {
        onBackClick()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = spacing16, vertical = spacing8),
    ) {
        item {
            DefaultToolbarWithRightIcon(
                onBackClick = onBackClick,
                buttonText = "Назад",
                icon = tandapp.icons.R.drawable.ic_like
            )
        }
        item {
            Spacer(modifier = Modifier.height(spacing12))
        }
        item {
            BannerPager(
                pagerState = pagerState,
                image = tandapp.icons.R.drawable.img_card_item,
                iconHeight = 235.dp,
                iconWidth = 290.dp,
            )
        }
        item {
            Spacer(modifier = Modifier.height(spacing24))
        }
        item {
            Text(
                text = "Кроссовки Pierre Cardin",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )
            Spacer(modifier = Modifier.height(spacing8))
            Text(
                text = "Women s Medium support",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
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
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                repeat(viewModel.shoesSizes.size) {
                    val selected = viewModel.selectedSize.value == viewModel.shoesSizes[it]
                    Box(
                        modifier = Modifier
                            .width(36.dp)
                            .height(28.dp)
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
        }
    }
}