package com.example.Loginscreen.app.Routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable

fun AppRouting(controller: NavHostController) {

    NavHost(
        startDestination = Routes.SPLASH,
        navController = controller
    ) {


    }
}