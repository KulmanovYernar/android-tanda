package tandapp.backetmodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import tandapp.backetmodule.viewmodels.BacketViewModel
import tandapp.navigationmodule.CustomBottomNavigation
import tandapp.navigationmodule.destinations.CatalogDestinations
import tandapp.utillibrary.buttons.CustomButton
import tandapp.utillibrary.buttons.CustomButtonText
import tandapp.utillibrary.toolbars.DefaultHomeToolbar
import tandapp.utillibrary.ui_components.Recommendations
import tandapp.utillibrary.values.Gray
import tandapp.utillibrary.values.Silver2
import tandapp.utillibrary.values.Silver4
import tandapp.utillibrary.values.cornerRadius8
import tandapp.utillibrary.values.fontSize11
import tandapp.utillibrary.values.fontSize14
import tandapp.utillibrary.values.fontSize16
import tandapp.utillibrary.values.lineHeight18
import tandapp.utillibrary.values.lineHeight22
import tandapp.utillibrary.values.spacing16
import tandapp.utillibrary.values.spacing18
import tandapp.utillibrary.values.spacing2
import tandapp.utillibrary.values.spacing20
import tandapp.utillibrary.values.spacing24
import tandapp.utillibrary.values.spacing4
import tandapp.utillibrary.values.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BacketScreen(
    navController: NavController,
    viewModel: BacketViewModel = getViewModel(),
    onBack: (String?) -> Unit
) {
    val scope = rememberCoroutineScope()
    val route = navController.currentBackStackEntry?.destination?.route
//    val lazyListState = rememberForeverLazyListState(key = "main",
//        initialData = viewModel.mainVerticalScrollState.value,
//        scrollStateCallback = viewModel.scrollStateSaveCallback)
    BackHandler {
        onBack(route)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getProducts()
    }
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
                    DefaultHomeToolbar(title = "Корзина",
                        titleColor = Color.Black,
                        onCityClick = {}
                    )
                }
            }
        },
        content = {
            it.calculateTopPadding()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = spacing8,
                        bottom = it.calculateBottomPadding(),
                        start = spacing16,
                        end = spacing16
                    )
            ) {
                if ((viewModel.productsForBacket.value?.productsSelected?.size ?: 0) > 0) {
                    items(viewModel.productsForBacket.value?.productsSelected?.size ?: 0) {
                        val product = viewModel.productsForBacket.value?.productsSelected?.get(it)
                        BacketItem(
                            product = product,
                            onDeleteProduct = {
                                viewModel.deleteProduct(product?.id ?: 0)
                            }
                        )
                        Spacer(modifier = Modifier.height(spacing16))
                    }
                    item {
                        Spacer(modifier = Modifier.height(spacing24))
                    }
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Bottom
                        ) {

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Total Payment",
                                    style = TextStyle(
                                        fontSize = fontSize14,
                                        lineHeight = lineHeight22,
                                        fontWeight = FontWeight(500),
                                        color = Color.Black,
                                    )
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "${viewModel.productsForBacket.value?.totalPrice} ₸",
                                    style = TextStyle(
                                        fontSize = fontSize14,
                                        lineHeight = lineHeight22,
                                        fontWeight = FontWeight(500),
                                        color = Color.Black,
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(spacing24))

                            CustomButton(
                                modifier = Modifier
                                    .height(40.dp),
                                content = {
                                    CustomButtonText(text = "Оформить заказ")
                                },
                                onButtonClicked = {}
                            )
                            Spacer(modifier = Modifier.height(spacing18))
                        }
                    }
                } else {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = spacing24),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(tandapp.icons.R.drawable.ic_backet),
                                contentDescription = null,
                                tint = Gray.copy(0.8f),
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.height(spacing2))
                            Text(
                                text = "Корзина пуста",
                                color = Color.Black,
                                fontSize = fontSize16,
                                lineHeight = lineHeight22,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(spacing4))
                            Text(
                                text = "Воспользуйтесь чатом, чтобы найти все, что нужно.",
                                color = Silver4,
                                fontSize = fontSize11,
                                lineHeight = lineHeight18,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.height(spacing8))
                            CustomButton(
                                modifier = Modifier
                                    .width(118.dp)
                                    .height(40.dp),
                                cornerRadius = cornerRadius8,
                                content = {
                                    CustomButtonText(
                                        text = "На главную",
                                        fontSize = fontSize16,
                                        lineHeight = lineHeight18
                                    )
                                }) {
                                onBack(route)
                            }
                            Spacer(modifier = Modifier.height(spacing24))
                        }
                    }


                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Silver2.copy(alpha = 0.8f))
                                .padding(vertical = spacing8),
                        ) {
                            Text(
                                text = "Рекомендуем",
                                color = Color.Black,
                                fontSize = fontSize16,
                                lineHeight = lineHeight22,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(spacing20))


                            Recommendations(
                                products = viewModel.previewProducts.value,
                                onClick = { id ->
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        "productId",
                                        id
                                    )
                                    navController.navigate(CatalogDestinations.CATALOG_PRODUCT_CARD_ITEM)
                                })
                        }
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