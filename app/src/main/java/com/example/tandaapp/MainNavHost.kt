package com.example.tandaapp

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.loginmodule.navigation.loginGraph
import tandapp.homemodule.navigation.homeGraph
import tandapp.navigationmodule.HOME_ROUTE
//import com.example.loginmodule.navigation.loginGraph
import tandapp.navigationmodule.LOGIN_ROUTE
import tandapp.navigationmodule.WELCOME_ROUTE
import tandapp.navigationmodule.destinations.MainDestinations

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = HOME_ROUTE,
    startRoute: String = HOME_ROUTE,
    onLogged: () -> Unit,
//    sharedHomeViewModel: HomeViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startRoute,
        enterTransition = { fadeIn(tween(600)) },
        exitTransition = { fadeOut(tween(600)) }
    ) {
        navigation(
            startDestination = startDestination,
            route = LOGIN_ROUTE
        ) {
            loginGraph(
                navController = navController,
                onLogged = onLogged,
            )
        }

        navigation(
            startDestination = MainDestinations.HOME.destination,
            route = HOME_ROUTE
        ) {
            homeGraph(
                navController = navController,
                onLogged = onLogged
            )
        }
    }
}