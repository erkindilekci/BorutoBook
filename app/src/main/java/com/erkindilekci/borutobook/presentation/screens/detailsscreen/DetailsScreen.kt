package com.erkindilekci.borutobook.presentation.screens.detailsscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.borutobook.presentation.screens.detailsscreen.components.DetailsScreenContent
import com.erkindilekci.borutobook.util.Constants.BASE_URL
import com.erkindilekci.borutobook.util.PaletteGenerator.convertImageUrlToBitmap
import com.erkindilekci.borutobook.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsScreen(
    navController: NavController,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val selectedHero by viewModel.selectedHero.collectAsState()
    val colorPalette by viewModel.colorPalette

    if (colorPalette.isNotEmpty()) {
        DetailsScreenContent(
            navController = navController,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    } else {
        viewModel.generateColorPalette()
    }

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                UiEvent.GenerateColorPalette -> {
                    val bitmap = convertImageUrlToBitmap(
                        imageUrl = "$BASE_URL${selectedHero?.image}",
                        context = context
                    )
                    if (bitmap != null) {
                        viewModel.setColorPalette(
                            colors = extractColorsFromBitmap(bitmap)
                        )
                    }
                }
            }
        }
    }
}
