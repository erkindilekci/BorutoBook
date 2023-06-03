package com.erkindilekci.borutobook.presentation.listscreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.erkindilekci.borutobook.presentation.listscreen.components.ListScreenTopAppBar
import com.erkindilekci.borutobook.presentation.util.ScreenContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            ListScreenTopAppBar(onSearchClicked = {})
        },
        content = {
            ScreenContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}
