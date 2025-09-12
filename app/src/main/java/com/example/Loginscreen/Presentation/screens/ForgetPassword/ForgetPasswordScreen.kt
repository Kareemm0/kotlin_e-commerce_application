package com.example.Loginscreen.Presentation.screens.ForgetPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.Loginscreen.Core.Component.CustomAppButton
import com.example.Loginscreen.Core.Component.CustomAppTextFormFiled
import com.example.Loginscreen.Core.Extensions.H
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import com.example.Loginscreen.Presentation.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetPasswordScreen(navigator: NavController, innerPadding: PaddingValues) {

    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }


    Scaffold(topBar = {


        TopAppBar(
            {
                Text("ForgetPassword ")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryColor,
                titleContentColor = offWhite,
                navigationIconContentColor = offWhite
            ),
            navigationIcon = {
                IconButton(
                    onClick = {
                        navigator.popBackStack()
                    }
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
            }

        )
    }
    ) { _ ->
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomAppTextFormFiled(
                email, {
                    email = it
                }, {
                    Text(
                        email.ifEmpty { "Email" },
                        color = if (emailError.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "")
                }
            )

            70.H
            CustomAppButton({}, "Confirm")
        }
    }


}