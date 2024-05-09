package tandapp.utillibrary.pagers

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tandapp.utillibrary.values.Base300
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing6

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    iconWidth:Dp = 343.dp,
    iconHeight:Dp = 134.dp,
    padding:Dp = spacing16,
    image:String
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .padding(horizontal = spacing16)
            .animateContentSize(animationSpec = tween(durationMillis = 500))
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .width(iconWidth)
                .height(iconHeight),
//            contentScale = ContentScale.FillWidth

        )
    }
    Spacer(modifier = Modifier.height(spacing6))

    HorizontalPagerIndicator(
        pagerState = pagerState,
        activeColor = Purple,
        inactiveColor = Base300,
        pageCount = 3,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = Purple,
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    iconWidth: Dp = 343.dp,
    iconHeight: Dp = 134.dp,
    padding: Dp = spacing16,
    image: String
) {
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = spacing16),
        modifier = modifier
            .padding(horizontal = spacing16)
            .animateContentSize(animationSpec = tween(durationMillis = 500))
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .width(306.dp)
                .height(240.dp),
            contentScale = ContentScale.FillWidth

        )
    }
    Spacer(modifier = Modifier.height(spacing6))

    HorizontalPagerIndicator(
        pagerState = pagerState,
        activeColor = Purple,
        inactiveColor = Base300,
        pageCount = 3,
    )
}
