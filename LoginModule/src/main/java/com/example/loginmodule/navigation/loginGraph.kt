package com.example.loginmodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.loginmodule.screens.WelcomeScreen
import tandapp.navigationmodule.WELCOME_ROUTE

fun NavGraphBuilder.loginGraph(navController: NavController, onLogged: () -> Unit){
    composable(route = WELCOME_ROUTE){
        WelcomeScreen()
    }
}