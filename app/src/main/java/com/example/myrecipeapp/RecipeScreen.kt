package com.example.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, recipeState: MainViewModel.RecipeState, navigateToDetail: (Category) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            recipeState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            recipeState.error != null -> {
                Text(text = "ERROR OCCURRED", modifier = Modifier.align(Alignment.Center))
            }
            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxSize().statusBarsPadding()
                ) {
                    items(recipeState.list) {
                            category -> CategoryItem(category = category, navigateToDetail = navigateToDetail)
                    }
                }
            }
        } //end when
    }
}


// How each Item looks like
@Composable
fun CategoryItem(category: Category, navigateToDetail: (Category) -> Unit) {
    Column (
        modifier = Modifier.padding(2.dp).fillMaxSize().clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb), //need io.coi-kt:coil-compose dependency for rememberAsyncImagePainter
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(3f / 4f).background(Color.DarkGray)
        )

        Text(
            text = category.strCategory,
            style = TextStyle(fontWeight = Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}