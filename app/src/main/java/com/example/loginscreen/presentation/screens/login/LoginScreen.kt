package com.example.loginscreen.presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.loginscreen.R

@Composable
fun LoginScreen(paddingValues: PaddingValues) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibality by remember { mutableStateOf(false) }
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
            .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally),
            composition = composition, progress = { progress }
        )
        Text(
            text = "Login", fontSize =
                24.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
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
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 4.dp, horizontal = 20.dp
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,


                )


        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = {
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
            visualTransformation = if (passwordVisibality) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibality)
                    painterResource(id = R.drawable.visibility) else
                    painterResource(id = R.drawable.visibility_off)

                Icon(
                    painter = image,
                    contentDescription = "",
                    modifier = Modifier.clickable { passwordVisibality = !passwordVisibality }
                )

            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 4.dp,
                    horizontal = 20.dp,
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
            )


        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 8.dp
                ),
            onClick = {
                emailError = if (email.isBlank()) "Email is required" else ""
                passwordError = if (password.isBlank()) "Password is Required " else ""
                if (emailError.isEmpty() && passwordError.isEmpty()) {
                    //! Handle Login Logic
                }
            }


        ) { Text(text = "Login ") }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Forget Password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable {
                    //! forget Password Logic
                }
                .align(
                    alignment = Alignment.End
                )
                .padding(
                    horizontal = 16.dp
                ),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "Don't Have an Account ?")
            Text(
                text = "Sign Up", color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    //! Handle Navigation To Sign UP Screen
                }
            )
        }

    }
}