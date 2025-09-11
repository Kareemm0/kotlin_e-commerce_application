package com.example.Loginscreen.Presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.Loginscreen.Core.Component.*
import com.example.Loginscreen.Core.Extensions.H
import com.example.Loginscreen.Presentation.Comonent.HaveAccountText
import com.example.Loginscreen.app.Routing.Routes
import com.example.Loginscreen.R

@Composable
fun LoginScreen(navigator: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.login))
    val progress by animateLottieCompositionAsState(
        isPlaying = true,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 0.7f
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Login", fontSize =
                24.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LottieAnimation(
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally),
            composition = composition, progress = { progress }
        )
        16.H
        CustomAppTextFormFiled(
            email,
            {
                email = it
            },
            label = {
                Text(
                    emailError.ifEmpty { "Email" },
                    color =
                        if (emailError.isNotEmpty()) Red else Unspecified
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Rounded.AccountCircle,
                    contentDescription = ""
                )
            },
        )
        16.H
        CustomAppTextFormFiled(
            password,
            {
                password = it
            },
            label = {
                Text(
                    passwordError.ifEmpty { "Password" },
                    color = if (passwordError.isNotEmpty()) Red else Unspecified
                )
            },
            leadingIcon = {
                Icon(Icons.Rounded.Lock, contentDescription = "")
            },
            trailingIcon = {
                val image = if (passwordVisibility)
                    painterResource(id = R.drawable.visibility) else
                    painterResource(id = R.drawable.visibility_off)

                Icon(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier.clickable { passwordVisibility = !passwordVisibility }
                )
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        )
        16.H
        CustomAppButton(
            textButton = "Login",
            onClick = {
                emailError = if (email.isBlank()) "Email is required" else ""
                passwordError = if (password.isBlank()) "Password is Required " else ""
                if (emailError.isEmpty() && passwordError.isEmpty()) {
                    //! Handle Login Logic
                }

            },
        )
        16.H
        Text(
            text = "Forget Password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable {
                    navigator.navigate(Routes.FORGETPASSWORD)
                }
                .align(
                    alignment = Alignment.End
                )
        )
        16.H
        HaveAccountText(true, navigator)


    }
}
