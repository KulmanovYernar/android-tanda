package tandapp.backetmodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.backetmodule.screens.BacketScreen
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.navigationmodule.navigateFromTabToHomeScreen

fun NavGraphBuilder.backetGraph(navController: NavController){
    composable(route = MainDestinations.BACKET.destination){
        BacketScreen(navController = navController,
            onBack = navController::navigateFromTabToHomeScreen
            )
    }
}