package tandapp.homemodule.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.utillibrary.textfields.DefaultTextField
import tandapp.utillibrary.toolbars.DefaultHomeToolbar
import tandapp.utillibrary.values.spacing4

@Composable
fun HomeScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
//    val lazyListState = rememberForeverLazyListState(key = "main",
//        initialData = viewModel.mainVerticalScrollState.value,
//        scrollStateCallback = viewModel.scrollStateSaveCallback)

    Scaffold(
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultHomeToolbar(title = "tandapp",
                onCityClick = {}
            )
        },
        content = {
            it.calculateTopPadding()
            LazyColumn() {
                item {
                    Row() {
                        DefaultTextField(value = "", hint = "Поиск", onValueChange = {})
                        Spacer(Modifier.width(spacing4))
                        Icon(
                            imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_filter),
                            contentDescription = null
                        )
                    }
                }
            }
        },
        bottomBar = {
            CustomBottomNavigation(
                navController = navController,
                scope = scope,
                onNavClick = { itemDest ->
                    scope.launch {

                    }
                }
            )
        }
    )
}