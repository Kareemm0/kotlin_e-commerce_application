package com.example.Loginscreen.Presentation.Component

import androidx.compose.material3.Badge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable

fun CustomBadgeItem(counter: Int? = null) {

    if (counter != null) {
        Badge {
            Text(counter.toString())
        }
    }
}