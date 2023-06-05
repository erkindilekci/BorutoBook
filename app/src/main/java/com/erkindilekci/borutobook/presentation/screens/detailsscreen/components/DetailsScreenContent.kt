package com.erkindilekci.borutobook.presentation.screens.detailsscreen.components

import android.graphics.Color.parseColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erkindilekci.borutobook.domain.model.Hero
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreenContent(
    navController: NavController,
    selectedHero: Hero?,
    colors: Map<String, String>
) {
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#FFFFFF") }

    LaunchedEffect(key1 = selectedHero) {
        vibrant = colors["vibrant"]!!
        darkVibrant = colors["darkVibrant"]!!
        onDarkVibrant = colors["onDarkVibrant"]!!
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color(parseColor(darkVibrant)))

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )

    val currentSheetFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue = if (scaffoldState.bottomSheetState.isCollapsed) 30.dp else 0.dp
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 130.dp,
        sheetContent = {
            selectedHero?.let {
                BottomSheetContent(
                    selectedHero = it,
                    infoBoxIconColor = Color(parseColor(vibrant)),
                    sheetBackgroundColor = Color(parseColor(darkVibrant)),
                    contentColor = Color(parseColor(onDarkVibrant))
                )
            }
        },
        content = {
            selectedHero?.let { hero ->
                BackgroundContent(
                    heroImage = hero.image,
                    imageFraction = currentSheetFraction,
                    onCloseClicked = { navController.popBackStack() },
                    backgroundColor = Color(parseColor(darkVibrant))
                )
            }
        },
        sheetShape = RoundedCornerShape(topStart = radiusAnim, topEnd = radiusAnim)
    )
}
