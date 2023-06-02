package com.erkindilekci.borutobook.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object WelcomeScreen : Screen("welcome_screen")
    object ListScreen : Screen("list_screen")
    object DetailScreen : Screen("detail_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "detail_screen/$heroId"
        }
    }
    object SearchScreen : Screen("search_screen")
}
