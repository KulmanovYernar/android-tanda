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
//import com.example.loginmodule.navigation.loginGraph
import tandapp.navigationmodule.LOGIN_ROUTE
import tandapp.navigationmodule.WELCOME_ROUTE

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = WELCOME_ROUTE,
    startRoute: String = WELCOME_ROUTE,
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
    }
}