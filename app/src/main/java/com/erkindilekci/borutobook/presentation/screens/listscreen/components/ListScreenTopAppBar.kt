package com.erkindilekci.borutobook.presentation.screens.listscreen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.erkindilekci.borutobook.R
import com.erkindilekci.borutobook.presentation.ui.theme.topAppBarBackgroundColor

@Composable
fun ListScreenTopAppBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.explore),
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        },
        backgroundColor = MaterialTheme.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = Color.White
                )
            }
        }
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkAppBar() {
    ListScreenTopAppBar(onSearchClicked = {})
}

@Preview
@Composable
fun LightAppBar() {
    ListScreenTopAppBar(onSearchClicked = {})
}
