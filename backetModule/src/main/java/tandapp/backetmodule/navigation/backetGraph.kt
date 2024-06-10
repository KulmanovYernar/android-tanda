package tandapp.backetmodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import tandapp.backetmodule.screens.PaymentScreen
import tandapp.navigationmodule.destinations.BacketDestinations

fun NavGraphBuilder.backetGraph(navController: NavController) {
    composable(route = BacketDestinations.PAYMENT_SCREEN) {
        PaymentScreen(
            onBackClick = {
                navController.navigateUp()
            },
        )
    }
}