package com.example.Loginscreen.Presentation.screens

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.Loginscreen.Data.bottomNavBarScreen

@Composable

fun BottomNavBarScreen(navigator: NavController) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Transparent
            ) {
                val navBar by navigator.currentBackStackEntryAsState()
                val currentIndex = navBar?.destination

                bottomNavBarScreen.forEach { item ->
                    val itemSelected =
                        currentIndex?.hierarchy?.any { it.route == item.route } == true

                    NavigationBarItem(
                        selected = itemSelected,
                        onClick = {
                           
                        },
                        icon = {
                            Icon(item.icon, contentDescription = "")
                        }, label = {
                            Text(item.title)
                        }
                    )

                }

            }
        }
    ) { _ ->

    }

}