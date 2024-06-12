package tandapp.profilemodule.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.androidx.compose.getViewModel
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.navigationmodule.destinations.ProfileDestinations
import tandapp.profilemodule.screens.WishListScreen

fun NavGraphBuilder.profileGraph(navController: NavController) {

    composable(route = ProfileDestinations.WISH_LIST) {
        val currentBackStackEntry = navController.currentBackStackEntry

        val wishListBackStackEntry = remember(currentBackStackEntry) {
            navController.getBackStackEntry(MainDestinations.PROFILE.destination)
        }

        WishListScreen(
            onBack = {
                navController.navigateUp()
            },
            onBasketCLick = {
                navController.navigate(MainDestinations.BACKET.destination)
            },
            viewModel = getViewModel(owner = wishListBackStackEntry)
        )
    }

}