package com.example.Loginscreen.Presentation.Component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.Loginscreen.Core.Extensions.W
import com.example.Loginscreen.Presentation.ui.theme.primaryColor
import com.example.Loginscreen.app.Routing.Routes

@Composable

fun HaveAccountText(isLogin: Boolean, navigator: NavController) {
    Row {

        Text(text = if (isLogin) "Don't Have an Account ? " else "Already Have Account ?")
        4.W
        Text(
            text = if (isLogin) "Sign Up" else "Login", color = primaryColor,
            modifier = Modifier.clickable {

                if (isLogin) navigator.navigate(Routes.SINGUP) else navigator.navigate(Routes.LOGIN)
            }
        )
    }
}