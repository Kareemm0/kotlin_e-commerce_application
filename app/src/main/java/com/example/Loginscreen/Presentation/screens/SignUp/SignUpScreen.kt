package com.example.Loginscreen.Presentation.screens.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.Loginscreen.Core.Component.CustomAppButton
import com.example.Loginscreen.Core.Component.CustomAppTextFormFiled
import com.example.Loginscreen.Core.Extensions.H
import com.example.Loginscreen.Presentation.Comonent.CustomCountriesDialog
import com.example.Loginscreen.Presentation.Comonent.HaveAccountText
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import com.example.Loginscreen.Presentation.ui.theme.primaryColor
import com.example.Loginscreen.R

@Composable

fun SignUpScreen(navigator: NavController) {

    //! Controllers
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    //! validations
    var userNameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var phoneError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var confirmPasswordError by remember { mutableStateOf("") }

    //! visibility State
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    //! Dialog State

    var isDialogOpen by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(

            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "SignUP", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(
                    Alignment.Start
                )
            )
            16.H
            //! User Name Filed
            CustomAppTextFormFiled(
                value = userName,
                {
                    userName = it
                },
                label = {
                    Text(
                        userNameError.ifEmpty { "User Name" }, color =
                            if (userName.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "")
                }
            )
            16.H
            //! Email Text Filed
            CustomAppTextFormFiled(
                value = email,
                {
                    email = it
                },
                label = {
                    Text(
                        emailError.ifEmpty { "Email" },
                        color = if (email.isNotEmpty()) Red else Unspecified
                    )
                }, leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "")
                }

            )
            16.H
            //! Phone Text Filed
            CustomAppTextFormFiled(
                value = phone,
                {
                    phone = it
                },
                label = {
                    Text(
                        phoneError.ifEmpty { "Phone Number " },
                        color = if (phone.isNotEmpty()) Red else Unspecified
                    )
                }, leadingIcon = {
                    Icon(Icons.Default.Phone, contentDescription = "")
                }

            )
            16.H
            //! Password Text Filed
            CustomAppTextFormFiled(
                value = password,
                {
                    password = it
                },
                label = {
                    Text(
                        passwordError.ifEmpty { "Password " },
                        color = if (password.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val image = if (passwordVisibility)
                        painterResource(id = R.drawable.visibility) else
                        painterResource(id = R.drawable.visibility_off)

                    Icon(
                        painter = image, contentDescription = "",
                        modifier = Modifier.clickable { passwordVisibility = !passwordVisibility }
                    )

                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

            )
            16.H
            //! Confirm Password  Text Filed
            CustomAppTextFormFiled(
                value = confirmPassword,
                {
                    confirmPassword = it
                },
                label = {
                    Text(
                        confirmPasswordError.ifEmpty { "Confirm Password " },
                        color = if (confirmPassword.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val image = if (confirmPasswordVisibility)
                        painterResource(id = R.drawable.visibility) else painterResource(id = R.drawable.visibility_off)
                    Icon(
                        painter = image,
                        modifier = Modifier.clickable {
                            confirmPasswordVisibility = !confirmPasswordVisibility
                        }, contentDescription = ""
                    )

                },
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation()

            )
            16.H
            //! Choose Country
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .clickable {
                        isDialogOpen = true
                    }
                    .fillMaxWidth(0.5f)
                    .background(
                        color = primaryColor, shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .align(Alignment.Start)

            )
            {
                Text(
                    "Choose Your Country",
                    color = offWhite
                )
            }
            24.H
            HaveAccountText(false, navigator)
            24.H
            CustomAppButton(
                onClick = {},
                textButton = "Sign Up"
            )


        }
    }

    if (isDialogOpen) {
        CustomCountriesDialog(
            {
                isDialogOpen = false
            },
            "Egypt",
            painterResource(R.drawable.ic_launcher_background)
        )
    }
}