package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Cabin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}


@Composable
fun HeroAppTopBar(modifier: Modifier = Modifier) {
   Surface (
       color = MaterialTheme.colorScheme.background,
       modifier = Modifier
           .fillMaxWidth()
   ){
       Text(
           text = "Superheroes",
           textAlign = TextAlign.Center,
           style = MaterialTheme.typography.displaySmall,
           fontFamily = Cabin
       )
   }
}  

@Composable
fun HeroApp(modifier: Modifier = Modifier) {

    var heroList = HeroesRepository.heroes
    
    Scaffold(
        topBar = {
            HeroAppTopBar()
        }
    ) {it ->
        LazyColumn(
        contentPadding = it
        ) {
            items(heroList) { hero ->
                SuperheroCard(hero = hero, modifier = Modifier
                    .padding(start = 16.dp, top= 8.dp, bottom = 8.dp, end = 16.dp))
            }
        }
    }
}
