package com.example.Loginscreen.Data

import com.example.Loginscreen.R

sealed class OnBoardingModel(
    val image: Int,
    val title: String,
    val subTitle: String
) {
    data object FirstPage : OnBoardingModel(
        image = R.drawable.onbarding1,
        title = "Discover our products",
        subTitle = "Browse thousands of products, from fashion to technology. Find what you love effortlessly."
    )

    data object SecondPage : OnBoardingModel(
        image = R.drawable.onbarding2,
        title = "Hassle-free checkout ✅",
        subTitle = "Smooth payments and fast delivery. Start shopping smarter today. ✅"
    )

    data object ThirdPage : OnBoardingModel(
        image = R.drawable.onbarding3,
        title = "Easy and Happy Shopping",
        subTitle = "Start shopping now and enjoy a world of convenience"
    )

    companion object {
        fun pages(): List<OnBoardingModel> = listOf(FirstPage, SecondPage, ThirdPage)
    }

}