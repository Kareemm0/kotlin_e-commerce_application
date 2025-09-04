package com.example.loginscreen.app.routing

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loginscreen.presentation.screens.foget_password.ForgetPasswordScreen
import com.example.loginscreen.presentation.screens.login.LoginScreen
import com.example.loginscreen.presentation.screens.signUp.SignUpScreen

@Composable

fun AppRouting(controller: NavHostController) {

    NavHost(
        startDestination = Routes.LOGIN,
        navController = controller
    ) {
        composable(Routes.LOGIN) { LoginScreen(paddingValues = PaddingValues(), controller) }
        composable(Routes.SINGUP) { SignUpScreen() }
        composable(Routes.FORGETPASSWORD) { ForgetPasswordScreen() }
    }
}