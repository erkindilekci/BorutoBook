package com.erkindilekci.borutobook.presentation.util

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.unit.dp
import com.erkindilekci.borutobook.MainActivity
import org.junit.Rule
import org.junit.Test

class RatingWidgetTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun passZeroPointZeroValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = 0.0)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(5)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(0)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(0)
    }

    @Test
    fun passOnePointSevenValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = 1.7)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(3)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(0)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(2)
    }

    @Test
    fun passTwoPointFourValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = 2.4)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(2)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(1)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(2)
    }

    @Test
    fun passFourPointZeroValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = 4.0)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(1)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(0)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(4)
    }

    @Test
    fun passInvalidValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = 5.1)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(5)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(0)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(0)
    }

    @Test
    fun passNegativeValue_Assert_CorrectStars() {
        composeRule.activity.setContent {
            RatingWidget(modifier = Modifier.padding(16.dp), rating = -2.1)
        }
        composeRule.onAllNodesWithContentDescription("EmptyStar").assertCountEquals(5)
        composeRule.onAllNodesWithContentDescription("HalfFilledStar").assertCountEquals(0)
        composeRule.onAllNodesWithContentDescription("FilledStar").assertCountEquals(0)
    }
}
