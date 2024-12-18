package com.example.tandaapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.tandaapp.MainNavHost
import com.example.tandaapp.ui.theme.TandaAppTheme
import tandapp.navigationmodule.HOME_ROUTE
import tandapp.utils.SharedPreferencesHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val registered = SharedPreferencesHelper.getRegistered()

        setContent {
            TandaAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray), color = Color.Gray
                ) {
                    MyTandaApp(
                        registered = registered,
//                        loginState = loginState.value,
//                        intent = intent,
//                        onDeepLinkNavigationComplete = { intent.data = null },
//                        onLogged = {
//                            setLogged()
//                        },
//                        context = this,
//                        sharedHomeViewModel = sharedHomeViewModel
                    )
                }
            }
        }
    }
}

@Composable
private fun MyTandaApp(
    registered: Boolean
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MainNavHost(
                modifier = Modifier
                    .fillMaxSize(),
                navController = navController,
                registered = registered,
                startRoute = HOME_ROUTE,
//                startDestination = getStartDestination(registered),
                onLogged = {}
//                    onLogged()
//                    if (intent?.data == null) {
//                        try {
//                            // if there is already main route
//                            navController.getBackStackEntry(MAIN_ROUTE)
//                            navController.popBackStack(
//                                route = LoginDestinations.FAST_ACCESS,
//                                inclusive = true
//                            )
//                        } catch (e: IllegalArgumentException) {
//                            // if there is no main route
//                            navController.navigate(
//                                route = MAIN_ROUTE,
//                                builder = { popUpTo(0, popUpToBuilder = { inclusive = true }) }
//                            )
//                        }
//                    } else {
//                        navController.popBackStack(route = LoginDestinations.FAST_ACCESS, inclusive = true)
//                        try {
//                            navController.handleDeepLink(intent = intent)
//                        } catch (e: Exception) {
//                            FirebaseCrashlytics.getInstance().log(e.toString())
//                        }
//                        onDeepLinkNavigationComplete()
//                    }
//                },
//                sharedHomeViewModel = sharedHomeViewModel

            )
//            if (isLoginRoute && (!isConnected || noInternetScreenEnabled)) {
//                LaunchedEffect(Unit) {
//                    noInternetScreenEnabled = true
//                }
//                NoInternetScreen(onConnectCheck = {
//                    noInternetScreenEnabled = connectState !is ConnectionState.Available
//                })
//            }
        }
    }
}