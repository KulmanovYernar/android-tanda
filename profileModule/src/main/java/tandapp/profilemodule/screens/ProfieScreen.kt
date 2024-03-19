package tandapp.profilemodule.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController,
    onBack: () -> Unit = {}
) {
    BackHandler {
        onBack()
    }

}