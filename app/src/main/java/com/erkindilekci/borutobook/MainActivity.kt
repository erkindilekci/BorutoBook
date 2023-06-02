package com.erkindilekci.borutobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.erkindilekci.borutobook.presentation.ui.theme.BorutoBookTheme
import com.erkindilekci.borutobook.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoBookTheme {
                Navigation()
            }
        }
    }
}
