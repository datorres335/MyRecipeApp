package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//setting up access to the base URL, INCLUDE HTTPS OR HTTP IF THE ORIGINAL URL DOES NOT AUTOMATICALLY CONTAIN IT
//must include this in your manifest <uses-permission android:name="android.permission.INTERNET" />
private val retrofit : Retrofit = Retrofit.Builder()
    .baseUrl("https:www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//setting up access to the file needed from the base URL
interface ApiService {
    @GET("categories.php") //need this to pull an online web file request, do not include the base URL "www.themealdb.com/api/json/v1/1/"
    suspend fun getCategories(): CategoriesResponse //indicates where to save the data
}

val recipeApiService : ApiService = retrofit.create(ApiService::class.java)