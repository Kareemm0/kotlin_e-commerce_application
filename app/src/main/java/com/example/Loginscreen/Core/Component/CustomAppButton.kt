package com.example.Loginscreen.Core.Component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable

fun CustomAppButton(
    onClick: () -> Unit,
    textButton: String,
    modifier: Modifier = Modifier

) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = textButton)
    }

}