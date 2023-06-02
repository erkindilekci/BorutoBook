package com.erkindilekci.borutobook.util

import androidx.annotation.DrawableRes
import com.erkindilekci.borutobook.R

sealed class OnBoardingScreen(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingScreen(
        image = R.drawable.welcome,
        title = "Welcome to the World of Boruto",
        description = "Are you a die-hard Boruto enthusiast? If so, get ready for some thrilling news!"
    )

    object Second : OnBoardingScreen(
        image = R.drawable.otaku,
        title = "Embark on an Epic Journey",
        description = "Uncover hidden secrets and dive deeper into the lives of your beloved Boruto heroes."
    )

    object Third : OnBoardingScreen(
        image = R.drawable.strength,
        title = "Unleash Unparalleled Power",
        description = "Witness the awe-inspiring might of your favorite heroes and compare their strength to others."
    )
}
