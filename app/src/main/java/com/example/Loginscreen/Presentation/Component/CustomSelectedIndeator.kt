package com.example.Loginscreen.Presentation.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.Loginscreen.Core.Extensions.W
import com.example.Loginscreen.Presentation.ui.theme.gray
import com.example.Loginscreen.Presentation.ui.theme.primaryColor

@Composable

fun CustomSelectedIndicator(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = primaryColor,
    unSelectedColor: Color = gray
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {
        repeat(pageSize) {
            4.W
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .width(if (it == currentPage) 40.dp else 20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = if (it == currentPage) selectedColor else unSelectedColor)

            )
            4.W
        }
    }

}