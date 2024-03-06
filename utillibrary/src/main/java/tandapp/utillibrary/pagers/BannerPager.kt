package tandapp.utillibrary.pagers

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tandapp.utillibrary.values.Base300
import tandapp.utillibrary.values.Base700
import tandapp.utillibrary.values.spacing6

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerPager(
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .wrapContentHeight()
            .animateContentSize(animationSpec = tween(durationMillis = 500))
    ) {
        Image(
            painter = painterResource(id = tandapp.icons.R.drawable.img_banner_friday),
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.height(spacing6))

    HorizontalPagerIndicator(
        pagerState = pagerState,
        activeColor = Base700,
        inactiveColor = Base300,
        pageCount = 6,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = Base700,
    inactiveColor: Color = Base300,
    pageCount: Int,
//    pageIndexMapping: (Int) -> Int = {
//        if (it > widgets.size - 1) {
//            it % widgets.size
//        } else {
//            it
//        }
//    }
) {

    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)

            )
        }
    }
}