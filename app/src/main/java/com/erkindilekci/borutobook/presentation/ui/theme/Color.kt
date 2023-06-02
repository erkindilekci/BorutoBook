package com.erkindilekci.borutobook.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Red = Color(0xFFFF1818)
val GradiantRed = Color(0xFFdf0015)
val TopAppBarColor = Color(0xFFf1191c)

val GradiantBlack = Color(0xFF262626)

val LightGray = Color(0xFFd8d8d8)
val DarkGray = Color(0xFF2a2a2a)

val StarColor = Color(0xFFffc94d)

val ShimmerLightGray = Color(0xFFf1f1f1)
val ShimmerMediumGray = Color(0xFFe3e3e3)
val ShimmerDarkGray = Color(0xFF1d1d1d)

val MaterialTheme.backGroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val MaterialTheme.titleColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray

val MaterialTheme.descriptionColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray.copy(0.5f) else DarkGray .copy(0.5f)

val MaterialTheme.activeIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Red else GradiantRed

val MaterialTheme.inactiveIndicatorColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray

val MaterialTheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else TopAppBarColor

val MaterialTheme.shimmerBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray

val MaterialTheme.shimmerItemColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray