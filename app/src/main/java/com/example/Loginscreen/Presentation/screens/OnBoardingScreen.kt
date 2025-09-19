package com.example.Loginscreen.Presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.Loginscreen.Core.Component.CustomAppButton
import com.example.Loginscreen.Core.Extensions.H
import com.example.Loginscreen.Core.Extensions.W
import com.example.Loginscreen.Data.Models.OnBoardingModel
import com.example.Loginscreen.Presentation.Component.CustomSelectedIndicator
import com.example.Loginscreen.Presentation.ui.theme.primaryColor
import com.example.Loginscreen.app.Routing.Routes
import kotlinx.coroutines.launch

@Composable

fun OnBoardingScreen(navigator: NavController) {

    val pages = OnBoardingModel.pages()
    val pageState = rememberPagerState(initialPage = 0) { pages.size }
    val buttonState = remember {
        derivedStateOf {
            when (pageState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back , Next")
                2 -> listOf("Back , Start")
                else -> listOf("", "")

            }
        }
    }

    val animationScope = rememberCoroutineScope()



    Scaffold(

        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    if (buttonState.value[0].isNotEmpty()) CustomAppButton(
                        {

                            animationScope.launch {
                                if (pageState.currentPage > 0) {
                                    pageState.animateScrollToPage(pageState.currentPage - 1)
                                }
                            }

                        },
                        "Back",
                        containerColor = Transparent,
                        contentColor = primaryColor,
                        borderColor = primaryColor,
                    )
                }
                16.W
                Box(modifier = Modifier.weight(1f)) {
                    CustomSelectedIndicator(
                        pageSize = pages.size,
                        currentPage = pageState.currentPage,
                    )
                }
                16.W
                Box(modifier = Modifier.weight(1f)) {
                    CustomAppButton({
                        animationScope.launch {
                            if (pageState.currentPage < pages.size - 1) {
                                pageState.animateScrollToPage(pageState.currentPage + 1)
                            } else {
                                navigator.navigate(Routes.LOGIN)
                            }
                        }
                    }, if (pageState.currentPage == 2) "Start" else "Next")
                }

            }
        }, content = {


            Column(
                modifier = Modifier
                    .padding(it)


            ) {

                HorizontalPager(pageState) { index ->
                    40.H
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd,

                            ) {
                            CustomAppButton(
                                {
                                    navigator.navigate(Routes.LOGIN)
                                },
                                "Skip",
                                containerColor = Transparent,
                                contentColor = primaryColor,
                                fraction = 0.3f
                            )
                        }
                        Image(
                            painter = painterResource(pages[index].image), contentDescription = "",
                            Modifier.size(400.dp)
                        )
                        Spacer(modifier = Modifier.weight(0.5f))

                        Text(
                            pages[index].title,
                            fontSize = 24.sp,
                            fontWeight = Bold,
                            color = primaryColor
                        )
                        16.H
                        Text(
                            pages[index].subTitle,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Medium,
                        )
                        Spacer(modifier = Modifier.weight(1f))

                    }
                }


            }
        }
    )
}


