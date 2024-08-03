package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val recipeState : MainViewModel.RecipeState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screens.RecipeScreen.route) {
        composable(route = Screens.RecipeScreen.route) {
            RecipeScreen(
                recipeState = recipeState,
                navigateToDetail = {
                //This part is responsible for passing data from the current screen to the CategoryDetailScreen.
                // It utilizes the savedStateHandle, which is a component of the Compose navigation framework
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", it) // it: Category
                    navController.navigate(Screens.CategoryDetailScreen.route)
                }
            )
        }
        composable(route = Screens.CategoryDetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}
