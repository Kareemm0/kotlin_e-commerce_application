package com.example.Loginscreen.app.Routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.Loginscreen.Presentation.screens.BottomNavBarScreen
import com.example.Loginscreen.Presentation.screens.CartScreen
import com.example.Loginscreen.Presentation.screens.ForgetPasswordScreen
import com.example.Loginscreen.Presentation.screens.HomeScreen
import com.example.Loginscreen.Presentation.screens.OnBoardingScreen
import com.example.Loginscreen.Presentation.screens.SignUpScreen
import com.example.Loginscreen.Presentation.screens.SplashScreen
import com.example.Loginscreen.Presentation.screens.LoginScreen
import com.example.Loginscreen.Presentation.screens.SearchScreen
import com.example.Loginscreen.Presentation.screens.SettingsScreen

@Composable

fun AppRouting(controller: NavHostController) {

    NavHost(
        startDestination = Routes.SPLASH,
        navController = controller
    ) {
        composable(Routes.LOGIN) { LoginScreen(controller) }
        composable(Routes.SINGUP) { SignUpScreen(controller) }
        composable(Routes.FORGETPASSWORD) { ForgetPasswordScreen(controller) }
        composable(Routes.SPLASH) { SplashScreen(controller) }
        composable(Routes.ONBOARDING) { OnBoardingScreen(controller) }
        composable(Routes.NAVBAR) { BottomNavBarScreen(controller) }
      
    }
}