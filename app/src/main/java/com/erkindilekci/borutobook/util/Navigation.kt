package com.erkindilekci.borutobook.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erkindilekci.borutobook.presentation.screens.detailsscreen.DetailsScreen
import com.erkindilekci.borutobook.presentation.screens.listscreen.ListScreen
import com.erkindilekci.borutobook.presentation.screens.searchscreen.SearchScreen
import com.erkindilekci.borutobook.presentation.screens.splashscreen.SplashScreen
import com.erkindilekci.borutobook.presentation.screens.welcomescreen.WelcomeScreen
import com.erkindilekci.borutobook.util.Constants.DETAIL_SCREEN_ARGUMENT_KEY

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.ListScreen.route) {
            ListScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument(DETAIL_SCREEN_ARGUMENT_KEY) { type = NavType.IntType })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}
