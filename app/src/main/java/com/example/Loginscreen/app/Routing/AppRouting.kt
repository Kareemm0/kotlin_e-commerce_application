package com.example.Loginscreen.app.Routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.Loginscreen.Presentation.screens.ForgetPassword.ForgetPasswordScreen
import com.example.Loginscreen.Presentation.screens.SignUp.SignUpScreen
import com.example.Loginscreen.Presentation.screens.login.LoginScreen

@Composable

fun AppRouting(controller: NavHostController) {

    NavHost(
        startDestination = Routes.LOGIN,
        navController = controller
    ) {
        composable(Routes.LOGIN) { LoginScreen(controller) }
        composable(Routes.SINGUP) { SignUpScreen() }
        composable(Routes.FORGETPASSWORD) { ForgetPasswordScreen() }
    }
}