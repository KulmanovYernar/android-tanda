package tandapp.utillibrary.pagers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerPager(
    pagerState: PagerState
){
    HorizontalPager(state = rememberPagerState(pageCount = {3})) {

    }
}