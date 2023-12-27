package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.md_theme_dark_errorContainer
import com.example.compose.md_theme_dark_onPrimaryContainer
import com.example.compose.md_theme_dark_primaryContainer
import com.example.compose.md_theme_light_onPrimaryContainer
import com.example.compose.md_theme_light_primary
import com.example.compose.md_theme_light_primaryContainer
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Cabin
import com.example.superheroes.ui.theme.Typography


@Composable
fun SuperheroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = if(isSystemInDarkTheme()) md_theme_dark_primaryContainer else md_theme_light_primaryContainer,
            contentColor = if(isSystemInDarkTheme()) md_theme_dark_onPrimaryContainer else md_theme_light_onPrimaryContainer
        ),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
        ){

            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(2f)

            ){
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = Typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = Typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(id =hero.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(72.dp)
                    .fillMaxSize()

            )


        }
    }
}

@Preview
@Composable
fun Preview() {
    var hero = HeroesRepository.heroes[3]
    SuperheroCard(hero = hero)
}