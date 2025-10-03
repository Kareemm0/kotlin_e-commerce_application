package com.example.Loginscreen.Presentation.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.Loginscreen.Data.Models.CountriesModel
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import coil.compose.AsyncImage

@Composable

fun CustomCountriesDialog(
    onDismissable: () -> Unit,
    countries: List<CountriesModel>,
    image: Painter
) {

    Dialog(

        onDismissRequest = onDismissable,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(

            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(2.dp, color = Transparent)
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .background(color = offWhite, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center

        ) {
            LazyVerticalGrid(
                GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(countries.size) { index ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {


//                        AsyncImage(
//                            state = image
//
//                        )

                        Image(
                            painter = image,
                            contentDescription = "",

                            )
                        Text(countries[index].name)
                    }
                }
            }
        }
    }
}