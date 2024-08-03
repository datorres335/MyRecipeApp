package com.example.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Original json file (https://jsonformatter.org/#google_vignette) was composed of a single object (struct), in which its value was an array with 4 elements
@Parcelize // must include id("kotlin-parcelize") inside of the plugins sections of the gradle file
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
): Parcelable

data class CategoriesResponse(
    val categories: List<Category>
)