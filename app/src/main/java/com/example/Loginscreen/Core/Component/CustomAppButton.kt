package com.example.Loginscreen.Core.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.Loginscreen.Presentation.ui.theme.primaryColor

@Composable

fun CustomAppButton(
    onClick: () -> Unit,
    textButton: String,
    modifier: Modifier = Modifier

) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = primaryColor
        )

    ) {
        Text(text = textButton)
    }

}