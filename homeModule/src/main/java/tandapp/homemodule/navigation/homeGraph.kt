package tandapp.homemodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.homemodule.screens.HomeScreen
import tandapp.navigationmodule.destinations.MainDestinations

fun NavGraphBuilder.homeGraph(navController: NavController, onLogged: () -> Unit) {

    composable(route = MainDestinations.HOME.destination){
        HomeScreen(
            navController = navController
        )
    }

}
