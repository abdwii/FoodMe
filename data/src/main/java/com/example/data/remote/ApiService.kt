package com.example.data.remote

import com.example.mylibrary.entity.CategoryResponse
import com.example.mylibrary.entity.MealDetails
import com.example.mylibrary.entity.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse

    @GET("filter.php")
    suspend fun getCatMeals(@Query("c") cat: String): MealsResponse

    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") id: String): MealDetails
}