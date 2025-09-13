package com.example.Loginscreen.Core.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.Loginscreen.Presentation.ui.theme.Purple40
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import com.example.Loginscreen.Presentation.ui.theme.primaryColor

@Composable

fun CustomAppButton(
    onClick: () -> Unit,
    textButton: String,
    modifier: Modifier = Modifier,
    fraction: Float = 1f,
    containerColor: Color = primaryColor,
    contentColor: Color = offWhite,
    buttonRadius: Dp = 16.dp,
    borderColor: Color = Transparent,


    ) {
    Button(
        border = ButtonDefaults.outlinedButtonBorder.copy(
            1.dp,
            brush = androidx.compose.ui.graphics.SolidColor(borderColor)

        ),
        shape = RoundedCornerShape(buttonRadius),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(fraction = fraction),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,

            )

    ) {
        Text(text = textButton)
    }

}