package com.erkindilekci.borutobook.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erkindilekci.borutobook.presentation.listscreen.ListScreen
import com.erkindilekci.borutobook.presentation.splashscreen.SplashScreen
import com.erkindilekci.borutobook.presentation.welcomescreen.WelcomeScreen
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
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument(DETAIL_SCREEN_ARGUMENT_KEY) { type = NavType.IntType })
        ) {

        }
        composable(route = Screen.SearchScreen.route) {

        }
    }
}
