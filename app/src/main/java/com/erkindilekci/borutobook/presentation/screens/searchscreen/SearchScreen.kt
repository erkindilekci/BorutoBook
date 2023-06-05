package com.erkindilekci.borutobook.presentation.screens.searchscreen

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.erkindilekci.borutobook.presentation.ui.theme.statusBarColor
import com.erkindilekci.borutobook.presentation.util.ScreenContent
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery
    val heroes = viewModel.searchedHeroes.collectAsLazyPagingItems()

    val systemUiController = rememberSystemUiController()
    val statusBarColor = MaterialTheme.statusBarColor

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
    }

    Scaffold(
        topBar = {
            SearchScreenTopAppBar(
                text = searchQuery,
                onTextChange = { viewModel.updateSearchQuery(it) },
                onSearchClicked = { viewModel.searchHeroes(it) },
                onCloseClicked = { navController.popBackStack() }
            )
        },
        content = {
            ScreenContent(heroes = heroes, navController = navController)
        }
    )
}
