package tandapp.profilemodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.profilemodule.screens.ProfileScreen

fun NavGraphBuilder.profileGraph(navController: NavController) {

    composable(route = MainDestinations.PROFILE.destination){
        ProfileScreen(
            navController = navController
        )
    }

}