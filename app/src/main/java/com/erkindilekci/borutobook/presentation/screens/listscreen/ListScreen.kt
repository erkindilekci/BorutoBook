package com.erkindilekci.borutobook.presentation.screens.listscreen

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.erkindilekci.borutobook.presentation.screens.listscreen.components.ListScreenTopAppBar
import com.erkindilekci.borutobook.presentation.ui.theme.statusBarColor
import com.erkindilekci.borutobook.presentation.util.ScreenContent
import com.erkindilekci.borutobook.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MaterialTheme.statusBarColor)

    Scaffold(
        topBar = {
            ListScreenTopAppBar(onSearchClicked = { navController.navigate(Screen.SearchScreen.route) })
        },
        content = {
            ScreenContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}
