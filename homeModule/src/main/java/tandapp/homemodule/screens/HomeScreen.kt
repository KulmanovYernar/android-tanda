package tandapp.homemodule.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import tandapp.homemodule.viewmodels.HomeViewModel
import tandapp.icons.R
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.navigationmodule.destinations.CatalogDestinations
import tandapp.navigationmodule.destinations.LoginDestinations
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.pagers.BannerPager
import tandapp.utillibrary.textfields.SearchText
import tandapp.utillibrary.toolbars.DefaultHomeToolbar
import tandapp.utillibrary.ui_components.BoxImage
import tandapp.utillibrary.ui_components.Recommendations
import tandapp.utillibrary.values.Purple
import tandapp.utillibrary.values.Silver2
import tandapp.utillibrary.values.cornerRadius20
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing12
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    registered: Boolean,
    viewModel: HomeViewModel = getViewModel()
) {
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
                    DefaultHomeToolbar(
                        title = "tandapp",
                        onCityClick = {},
                        icon = R.drawable.ic_tanda
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing16),
                    ) {
                        SearchText(
                            text = "",
                            onClick = {},
                            hint = "Поиск"
                        )
//                        Spacer(Modifier.width(spacing4))
//                        BoxImage(
//                            imageRes = R.drawable.ic_filter_white,
//                            boxSize = 40.dp,
//                            maxWidth = 16.dp,
//                            maxHeight = 16.dp,
//                            cornerRadius = cornerRadius10
//                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(spacing12))
                }

                item {
                    BannerPager(pagerState = pagerState)
                }

                item {
                    Spacer(modifier = Modifier.height(spacing20))
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing16),
                    ) {
                        BoxImage(
                            imageRes = R.drawable.ic_profile,
                            boxSize = 40.dp,
                            cornerRadius = cornerRadius20
                        )
                        Spacer(modifier = Modifier.width(spacing8))

                        CustomButton(
                            buttonColors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Purple
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .border(
                                    1.dp, color = Purple, shape = RoundedCornerShape(
                                        cornerRadius20
                                    )
                                ),
                            enabled = true,
                            onButtonClicked = { navController.navigate(LoginDestinations.SIGN_IN) },
                            content = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    CustomButtonText(
                                        text = "Войдите или зарегистрируйтесь ->",
                                        color = Purple
                                    )
                                }
                            }
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(spacing16))
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Silver2.copy(alpha = 0.8f))
                            .padding(horizontal = spacing16, vertical = spacing8),
                    ) {
                        Text(
                            text = "Рекомендуем",
                            color = Color.Black,
                            fontSize = fontSize16,
                            lineHeight = lineHeight22,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(spacing20))


                        Recommendations(onClick = {
                            navController.navigate(CatalogDestinations.CATALOG_PRODUCT_CARD_ITEM)
                        })
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