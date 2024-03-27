package tandapp.navigationmodule

import android.annotation.SuppressLint
import android.util.Log
import androidx.navigation.NavController
import tandapp.navigationmodule.destinations.MainDestinations

fun NavController.returnToHomeScreen(route:String? = "") {
    Log.d("navigateFromTabToHomeScreen", "navigateFromTabToHomeScreen: 222")
    this.navigate(route = MainDestinations.HOME.destination, builder = {
        launchSingleTop = true
        popUpTo(route = route.orEmpty(), popUpToBuilder = { inclusive = true })
    })
}
@SuppressLint("RestrictedApi")
fun NavController.navigateFromTabToHomeScreen(route: String? = "") {
    if (this.findDestination(MainDestinations.HOME.destination) == null) {
        Log.d("navigateFromTabToHomeScreen", "navigateFromTabToHomeScreen: 111")
        this.navigate(
            MainDestinations.HOME.destination, builder = {
                launchSingleTop = true
                popUpTo(route = MainDestinations.HOME.destination, popUpToBuilder = { inclusive = false })
            }
        )
    } else {
        this.returnToHomeScreen(route)
    }
}