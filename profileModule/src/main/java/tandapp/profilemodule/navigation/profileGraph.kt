package tandapp.profilemodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.navigationmodule.destinations.ProfileDestinations
import tandapp.navigationmodule.navigateFromTabToHomeScreen
import tandapp.profilemodule.screens.ProfileScreen
import tandapp.profilemodule.screens.WishListScreen

fun NavGraphBuilder.profileGraph(navController: NavController) {

    composable(route = ProfileDestinations.WISH_LIST) {
        WishListScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }

}