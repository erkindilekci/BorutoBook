package com.erkindilekci.borutobook.presentation.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.erkindilekci.borutobook.domain.model.Hero

@Composable
fun ScreenContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = heroes,
            key = { hero -> hero.id }
        ) {
            it?.let { hero -> 
                HeroItem(hero = hero, navController = navController)
            }
        }
    }
}
