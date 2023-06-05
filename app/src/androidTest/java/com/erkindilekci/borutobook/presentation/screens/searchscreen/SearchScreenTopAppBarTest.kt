package com.erkindilekci.borutobook.presentation.screens.searchscreen

import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.erkindilekci.borutobook.MainActivity
import org.junit.Rule
import org.junit.Test

class SearchScreenTopAppBarTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun openSearchWidget_addInputText_assertInputText() {
        composeRule.activity.setContent {
            val text = remember { mutableStateOf("") }
            SearchAppBar(
                text = text.value,
                onTextChange = { text.value = it },
                onCloseClicked = {},
                onSearchClicked = {}
            )
        }

        composeRule.onNodeWithContentDescription("TextField").performTextInput("test")
        composeRule.onNodeWithContentDescription("TextField").assertTextEquals("test")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonOnce_assertEmptyInputText() {
        composeRule.activity.setContent {
            val text = remember { mutableStateOf("") }
            SearchAppBar(
                text = text.value,
                onTextChange = { text.value = it },
                onCloseClicked = {},
                onSearchClicked = {}
            )
        }

        composeRule.onNodeWithContentDescription("TextField").performTextInput("test")
        composeRule.onNodeWithContentDescription("CloseIcon").performClick()
        composeRule.onNodeWithContentDescription("TextField").assertTextContains("")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonTwice_assertClosedState() {
        composeRule.activity.setContent {
            val text = remember { mutableStateOf("") }
            val searchTextFieldClosed = remember { mutableStateOf(false) }
            if (!searchTextFieldClosed.value) {
                SearchAppBar(
                    text = text.value,
                    onTextChange = { text.value = it },
                    onCloseClicked = { searchTextFieldClosed.value = true },
                    onSearchClicked = {}
                )
            }
        }

        composeRule.onNodeWithContentDescription("TextField").performTextInput("test")
        composeRule.onNodeWithContentDescription("CloseIcon").performClick()
        composeRule.onNodeWithContentDescription("CloseIcon").performClick()
        composeRule.onNodeWithContentDescription("SearchAppBar").assertDoesNotExist()
    }

    @Test
    fun openSearchWidget_pressCloseButtonOnce_whenInputIsEmpty_assertClosedState() {
        composeRule.activity.setContent {
            val text = remember { mutableStateOf("") }
            val searchTextFieldClosed = remember { mutableStateOf(false) }
            if (!searchTextFieldClosed.value) {
                SearchAppBar(
                    text = text.value,
                    onTextChange = { text.value = it },
                    onCloseClicked = { searchTextFieldClosed.value = true },
                    onSearchClicked = {}
                )
            }
        }

        composeRule.onNodeWithContentDescription("CloseIcon").performClick()
        composeRule.onNodeWithContentDescription("SearchAppBar").assertDoesNotExist()
    }
}
