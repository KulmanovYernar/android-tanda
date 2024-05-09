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
import tandapp.backetmodule.navigation.backetGraph
import tandapp.catalogmodule.navigation.catalogGraph
import tandapp.homemodule.navigation.mainGraph
import tandapp.navigationmodule.BACKET_ROUTE
import tandapp.navigationmodule.CATALOG_ROUTE
import tandapp.navigationmodule.CHAT_ROUTE
import tandapp.navigationmodule.HOME_ROUTE
import tandapp.navigationmodule.LOGIN_ROUTE
import tandapp.navigationmodule.PROFILE_ROUTE
import tandapp.navigationmodule.destinations.CatalogDestinations.CATALOG_PRODUCT_CARD_ITEM
import tandapp.navigationmodule.destinations.MainDestinations
import tandapp.profilemodule.navigation.profileGraph

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    registered: Boolean,
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
            mainGraph(
                navController = navController,
                onLogged = onLogged,
                registered = registered
            )
        }
        navigation(
            startDestination = MainDestinations.BACKET.destination,
            route = BACKET_ROUTE
        ) {
            backetGraph(
                navController = navController
            )
        }
        navigation(
            startDestination = MainDestinations.PROFILE.destination,
            route = PROFILE_ROUTE
        ) {
            profileGraph(
                navController = navController
            )
        }

        navigation(
            startDestination = CATALOG_PRODUCT_CARD_ITEM,
            route = CATALOG_ROUTE
        ) {
            catalogGraph(
                navController = navController
            )
        }

        navigation(
            startDestination = MainDestinations.CHAT.destination,
            route = CHAT_ROUTE
        ) {

        }
    }
}