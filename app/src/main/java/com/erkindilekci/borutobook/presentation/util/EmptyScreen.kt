package com.erkindilekci.borutobook.presentation.util

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.erkindilekci.borutobook.R
import com.erkindilekci.borutobook.presentation.ui.theme.iconColor

@Composable
fun EmptyScreen(error: LoadState.Error) {
    val message by rememberSaveable { mutableStateOf(parseErrorMessage(error.toString())) }
    val icon by rememberSaveable { mutableStateOf(R.drawable.network_error) }

    var startAnimation by rememberSaveable { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 0.7f else 0f,
        animationSpec = tween(1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .alpha(alphaAnim)
                .size(120.dp),
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.error_icon),
            tint = MaterialTheme.iconColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            modifier = Modifier.alpha(alphaAnim),
            text = message,
            color = MaterialTheme.iconColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}

fun parseErrorMessage(message: String): String {
    return when {
        message.contains("SocketTimeoutException") -> "Server Unavailable."
        message.contains("ConnectException") -> "Internet Unavailable."
        else -> "Unknown Error."
    }
}
