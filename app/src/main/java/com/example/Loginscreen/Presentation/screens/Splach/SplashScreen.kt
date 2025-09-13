package com.example.Loginscreen.Presentation.screens.Splach

import android.window.SplashScreen
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.Loginscreen.R
import com.example.Loginscreen.app.Routing.Routes
import kotlinx.coroutines.delay


@Composable

fun SplashScreen(navigator: NavController) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.spalsh))
    val progress by animateLottieCompositionAsState(
        isPlaying = true,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 0.7f
    )

    LaunchedEffect(Unit) {
        delay(7000)

        navigator.navigate(Routes.ONBOARDING)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        LottieAnimation(
            progress = { progress },
            composition = composition
        )
    }
}