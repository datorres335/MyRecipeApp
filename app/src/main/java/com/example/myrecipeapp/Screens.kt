package com.example.myrecipeapp

// this class should take care of individual routes
sealed class Screens (val route: String) {
    object RecipeScreen: Screens("recipe_screen")
    object CategoryDetailScreen: Screens("category_detail_screen")
}
