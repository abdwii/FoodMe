package com.example.mylibrary.repo

import com.example.mylibrary.entity.CategoryResponse
import com.example.mylibrary.entity.MealDetails
import com.example.mylibrary.entity.MealsResponse

interface Repo {
    suspend fun getMealsFromRemote(): CategoryResponse
    suspend fun getCatMealsFromRemote(cat: String): MealsResponse
    suspend fun getMealDetailsFromRemote(id: String): MealDetails
}