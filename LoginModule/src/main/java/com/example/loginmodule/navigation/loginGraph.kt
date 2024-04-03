package com.example.loginmodule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.loginmodule.screens.AccountSubmittingScreen
import com.example.loginmodule.screens.ConfirmOtpScreen
import com.example.loginmodule.screens.LoginScreen
import com.example.loginmodule.screens.PasswordRecoveryScreen
import com.example.loginmodule.screens.WelcomeScreen
import com.example.loginmodule.screens.old.RegistrationScreenOld
import tandapp.navigationmodule.WELCOME_ROUTE
import tandapp.navigationmodule.destinations.LoginDestinations

fun NavGraphBuilder.loginGraph(navController: NavController, onLogged: () -> Unit) {
    val onBack = { navController.navigateUp() }
    composable(route = WELCOME_ROUTE) {
        WelcomeScreen(
            onBeginClick = { navController.navigate(LoginDestinations.SIGN_IN) }
        )
    }
    composable(route = LoginDestinations.SIGN_IN) {
        LoginScreen(
            onForgotPasswordClick = { navController.navigate(LoginDestinations.FORGOT_PASSWORD) },
            onLoginClick = { navController.navigate(LoginDestinations.CONFIRM_OTP_CODE) },
            onBack = { navController.navigateUp() }
        )
    }

    composable(route = LoginDestinations.CONFIRM_OTP_CODE) {
        ConfirmOtpScreen(
            onBackClick = {
                navController.navigateUp()
            },
            onSuccess = {

            },
            navController = navController
        )
    }

    composable(route = LoginDestinations.REGISTRATION_SCREEN) {
        RegistrationScreenOld(
            onBackClick = { onBack() },
            onSubmitClick = {},
        )
    }

    composable(route = LoginDestinations.FORGOT_PASSWORD) {
        PasswordRecoveryScreen(
            onBackClick = { onBack() },
            onSubmitClick = {},
        )
    }
    composable(route = LoginDestinations.ACCOUNT_SUBMITTING) {
        AccountSubmittingScreen(
            onBackClick = { onBack() },
        )
    }
}