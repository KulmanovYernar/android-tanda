package tandapp.utillibrary.ui_components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tandapp.utillibrary.pagers.BannerPager
import tandapp.utillibrary.toolbars.DefaultToolbarWithRightIcon
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCardItem(
    onBackClick: () -> Unit = {},
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
                text = "Размер: 37",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                )
            )
            Spacer(modifier = Modifier.height(spacing8))
//            Text(
//                text = "Размер: 37",
//                style = TextStyle(
//                    fontSize = 13.sp,
//                    lineHeight = 18.sp,
//                    fontWeight = FontWeight(400),
//                    color = Color.Black,
//                )
//            )
        }
    }
}