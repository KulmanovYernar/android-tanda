package tandapp.homemodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.backetmodule.screens.BacketScreen
import tandapp.catalogmodule.screens.CatalogScreen
import tandapp.chatmodule.screens.ChatScreen
import tandapp.homemodule.screens.HomeScreen
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.navigationmodule.navigateFromTabToHomeScreen
import tandapp.profilemodule.screens.ProfileScreen

fun NavGraphBuilder.mainGraph(navController: NavController, onLogged: () -> Unit) {

    composable(route = MainDestinations.HOME.destination) {
        HomeScreen(
            navController = navController
        )
    }

    composable(route = MainDestinations.CATALOG.destination) {
        CatalogScreen(
            navController = navController,
            onBack = {
                navController.navigateFromTabToHomeScreen(it)
            }
        )
    }

    composable(route = MainDestinations.CHAT.destination) {
        ChatScreen(
            navController = navController,
            onBack = {
                navController.navigateFromTabToHomeScreen(it)
            }
        )
    }

    composable(route = MainDestinations.BACKET.destination) {
        BacketScreen(navController = navController,
            onBack = {
                navController.navigateFromTabToHomeScreen(it)
            }
        )
    }

    composable(route = MainDestinations.PROFILE.destination) {
        ProfileScreen(
            navController = navController,
            onBack = {
                navController.navigateFromTabToHomeScreen(it)
            }
        )
    }

}
