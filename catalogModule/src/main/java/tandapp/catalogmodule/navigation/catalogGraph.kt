package tandapp.catalogmodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.navigationmodule.destinations.CatalogDestinations
import tandapp.catalogmodule.screens.ProductCardItem

fun NavGraphBuilder.catalogGraph(navController: NavController) {
    composable(route = CatalogDestinations.CATALOG_PRODUCT_CARD_ITEM) {
        ProductCardItem(
            onBackClick = { navController.navigateUp() }
        )
    }
}