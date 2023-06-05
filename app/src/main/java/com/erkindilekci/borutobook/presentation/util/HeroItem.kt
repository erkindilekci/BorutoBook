package com.erkindilekci.borutobook.presentation.util

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.erkindilekci.borutobook.R
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.util.Constants.BASE_URL
import com.erkindilekci.borutobook.util.Screen

@Composable
fun HeroItem(
    hero: Hero,
    navController: NavController
) {
    val url by rememberSaveable { mutableStateOf("$BASE_URL${hero.image}") }

    Box(
        modifier = Modifier
            .height(400.dp)
            .clickable { navController.navigate(Screen.DetailsScreen.passHeroId(heroId = hero.id)) },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(20.dp)) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = url,
                contentDescription = hero.name,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = hero.name,
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(modifier = Modifier.padding(end = 12.dp), rating = hero.rating)

                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = 0.6f),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeroItemPrev() {
    Column {
        Spacer(modifier = Modifier.height(20.dp))

        HeroItem(
            hero = Hero(
                id = 1,
                name = "Erkin",
                image = "",
                about = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                rating = 4.9,
                power = 99,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            navController = rememberNavController()
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HeroItemDarkPrev() {
    Column {
        Spacer(modifier = Modifier.height(20.dp))

        HeroItem(
            hero = Hero(
                id = 1,
                name = "Erkin",
                image = "",
                about = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                rating = 4.9,
                power = 99,
                month = "",
                day = "",
                family = listOf(),
                abilities = listOf(),
                natureTypes = listOf()
            ),
            navController = rememberNavController()
        )
    }
}
