package com.erkindilekci.borutobook.presentation.screens.welcomescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.borutobook.R
import com.erkindilekci.borutobook.presentation.ui.theme.GradiantRed
import com.erkindilekci.borutobook.presentation.ui.theme.activeIndicatorColor
import com.erkindilekci.borutobook.presentation.ui.theme.backGroundColor
import com.erkindilekci.borutobook.presentation.ui.theme.descriptionColor
import com.erkindilekci.borutobook.presentation.ui.theme.titleColor
import com.erkindilekci.borutobook.util.OnBoardingScreen
import com.erkindilekci.borutobook.util.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeScreenViewModel = hiltViewModel()
) {
    val pages = listOf(OnBoardingScreen.First, OnBoardingScreen.Second, OnBoardingScreen.Third)


    val pagerState = rememberPagerState(initialPage = 0) { 3 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.backGroundColor)
    ) {

        HorizontalPager(state = pagerState) { i ->
            val page = pages[i]

            Box(Modifier.fillMaxSize()) {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = page.image),
                        contentDescription = stringResource(R.string.on_boarding_image)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = page.title,
                        color = MaterialTheme.titleColor,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = page.description,
                        color = MaterialTheme.descriptionColor,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )

                    Spacer(modifier = Modifier.height(120.dp))

                    Row(
                        Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(pagerState.pageCount) { iteration ->
                            val color =
                                if (pagerState.currentPage == iteration) GradiantRed else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(10.dp)

                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(80.dp))

                }

                androidx.compose.animation.AnimatedVisibility(
                    visible = pagerState.currentPage == 2,
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxWidth()
                            .padding(bottom = 64.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.activeIndicatorColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(40),
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.ListScreen.route)
                            viewModel.saveOnBoardingState(true)
                        }
                    ) {
                        Text(text = stringResource(R.string.finish))
                    }
                }

            }
        }
    }
}
