package com.example.Loginscreen.Presentation.screens

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.Loginscreen.Core.Component.CustomAppButton
import com.example.Loginscreen.Core.Component.CustomAppTextFormFiled
import com.example.Loginscreen.Core.Extensions.H
import com.example.Loginscreen.Presentation.Component.CustomCountriesDialog
import com.example.Loginscreen.Presentation.Component.HaveAccountText
import com.example.Loginscreen.Presentation.ViewModels.SignUpViewModel
import com.example.Loginscreen.Presentation.ui.theme.offWhite
import com.example.Loginscreen.Presentation.ui.theme.primaryColor
import com.example.Loginscreen.R

@Composable

fun SignUpScreen(navigator: NavController) {

    val vm: SignUpViewModel = viewModel()


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
                value = vm.userName,
                {
                    vm.userName = it
                },
                label = {
                    Text(
                        vm.userNameError.ifEmpty { "User Name" }, color =
                            if (vm.userName.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "")
                }
            )
            16.H
            //! Email Text Filed
            CustomAppTextFormFiled(
                value = vm.email,
                {
                    vm.email = it
                },
                label = {
                    Text(
                        vm.emailError.ifEmpty { "Email" },
                        color = if (vm.email.isNotEmpty()) Red else Unspecified
                    )
                }, leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "")
                }

            )
            16.H
            //! Phone Text Filed
            CustomAppTextFormFiled(
                value = vm.phone,
                {
                    vm.phone = it
                },
                label = {
                    Text(
                        vm.phoneError.ifEmpty { "Phone Number " },
                        color = if (vm.phone.isNotEmpty()) Red else Unspecified
                    )
                }, leadingIcon = {
                    Icon(Icons.Default.Phone, contentDescription = "")
                }

            )
            16.H
            //! Password Text Filed
            CustomAppTextFormFiled(
                value = vm.password,
                {
                    vm.password = it
                },
                label = {
                    Text(
                        vm.passwordError.ifEmpty { "Password " },
                        color = if (vm.password.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val image = if (vm.passwordVisibility)
                        painterResource(id = R.drawable.visibility) else
                        painterResource(id = R.drawable.visibility_off)

                    Icon(
                        painter = image, contentDescription = "",
                        modifier = Modifier.clickable {
                            vm.passwordVisibility = !vm.passwordVisibility
                        }
                    )

                },
                visualTransformation = if (vm.passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()

            )
            16.H
            //! Confirm Password  Text Filed
            CustomAppTextFormFiled(
                value = vm.confirmPassword,
                {
                    vm.confirmPassword = it
                },
                label = {
                    Text(
                        vm.confirmPasswordError.ifEmpty { "Confirm Password " },
                        color = if (vm.confirmPassword.isNotEmpty()) Red else Unspecified
                    )
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val image = if (vm.confirmPasswordVisibility)
                        painterResource(id = R.drawable.visibility) else painterResource(id = R.drawable.visibility_off)
                    Icon(
                        painter = image,
                        modifier = Modifier.clickable {
                            vm.confirmPasswordVisibility = !vm.confirmPasswordVisibility
                        }, contentDescription = ""
                    )

                },
                visualTransformation = if (vm.confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation()

            )
            16.H
            //! Choose Country
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .clickable {
                        vm.isDialogOpen = true
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

    if (vm.isDialogOpen) {
        CustomCountriesDialog(
            {
                vm.isDialogOpen = false
            },
            countries = vm.state,
            image = painterResource(R.drawable.ic_launcher_background)

        )
    }
}