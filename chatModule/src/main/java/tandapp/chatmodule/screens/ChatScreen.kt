package tandapp.chatmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import tandapp.utillibrary.toolbars.DefaultChatToolbar
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(
    navController: NavController,
    onBack: (String?) -> Unit
) {
    val route = navController.currentBackStackEntry?.destination?.route
    BackHandler {
        onBack(route)
    }

    val scope = rememberCoroutineScope()
//    val lazyListState = rememberForeverLazyListState(key = "main",
//        initialData = viewModel.mainVerticalScrollState.value,
//        scrollStateCallback = viewModel.scrollStateSaveCallback)

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 6 })

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = spacing8, start = spacing16, end = spacing16)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    DefaultChatToolbar(
                        onBackClick = { navController.navigateUp() },
                        title = "Chat with AI",
                        icon = tandapp.icons.R.drawable.ic_robot
                    )
                }
            }
        },
        content = {
            it.calculateTopPadding()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = spacing8)
            ) {
                item {

                }

            }
        },
        bottomBar = {

        }
    )

}