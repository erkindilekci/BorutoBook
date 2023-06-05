package com.erkindilekci.borutobook.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object WelcomeScreen : Screen("welcome_screen")
    object ListScreen : Screen("list_screen")
    object DetailsScreen : Screen("details_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }

    object SearchScreen : Screen("search_screen")
}
