package com.example.Loginscreen.Data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.Loginscreen.app.Routing.Routes

data class BottomNavigationBarModel(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val badge: Int? = null,
)


var bottomNavBarScreen = listOf<BottomNavigationBarModel>(
    BottomNavigationBarModel("Home", Routes.HOME, Icons.Default.Home),
    BottomNavigationBarModel("Cart", Routes.Cart, Icons.Default.ShoppingCart),
    BottomNavigationBarModel("Search", Routes.SEARCH, Icons.Default.Search),
    BottomNavigationBarModel("Settings", Routes.SETTINGS, Icons.Default.Settings),
)