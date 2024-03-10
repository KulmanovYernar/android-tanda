package tandapp.navigationmodule

import android.annotation.SuppressLint
import androidx.navigation.NavController
import tandapp.navigationmodule.destinations.MainDestinations

fun NavController.returnToHomeScreen() {
    this.popBackStack(route = MainDestinations.HOME.destination, inclusive = true)
}
@SuppressLint("RestrictedApi")
fun NavController.navigateFromTabToHomeScreen(route:String?) { //TODO
    if (this.findDestination(MainDestinations.HOME.destination) == null) {
        this.navigate(
            MainDestinations.HOME.destination, builder = {
                launchSingleTop = true
                popUpTo(route = route.orEmpty(), popUpToBuilder = { inclusive = true })
            }
        )
    } else {
        this.returnToHomeScreen()
    }
}