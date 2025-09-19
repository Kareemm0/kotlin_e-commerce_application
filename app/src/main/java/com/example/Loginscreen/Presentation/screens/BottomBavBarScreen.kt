package com.example.Loginscreen.Presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.Loginscreen.Data.Models.bottomNavBarScreen
import com.example.Loginscreen.Presentation.Component.CustomBadgeItem
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import com.example.Loginscreen.Presentation.ui.theme.primaryColor
import com.example.Loginscreen.app.Routing.Routes

@Composable

fun BottomNavBarScreen(navigator: NavController) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Transparent
            ) {
                val navBar by navController.currentBackStackEntryAsState()
                val currentIndex = navBar?.destination?.route

                bottomNavBarScreen.forEach { item ->
                    val itemSelected =
                        currentIndex == item.route

                    NavigationBarItem(

                        colors = NavigationBarItemDefaults.colors(

                            indicatorColor = primaryColor,
                            selectedIconColor = offWhite,
                        ),
                        selected = itemSelected,
                        onClick = {
                            if (
                                currentIndex != item.route
                            ) {
                                navController.navigate(item.route) {
                                    popUpTo(navigator.graph.startDestinationId)
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                            println("=====${item.title} + $itemSelected")
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    CustomBadgeItem(item.badge)
                                }
                            ) {
                                Icon(
                                    item.icon, contentDescription = "",
                                )
                            }
                        }, label = {
                            Text(
                                item.title, color = if (itemSelected)
                                    primaryColor else Unspecified
                            )
                        }
                    )

                }

            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Routes.HOME) { HomeScreen() }
            composable(Routes.Cart) { CartScreen() }
            composable(Routes.SEARCH) { SearchScreen() }
            composable(Routes.SETTINGS) { SettingsScreen() }
        }
    }
}

