package com.example.Loginscreen.Core.Extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val Int.H @Composable get() = Spacer(modifier = Modifier.height(this.dp))

val Int.W @Composable get() = Spacer(modifier = Modifier.width(this.dp))