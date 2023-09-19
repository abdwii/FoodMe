package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.mylibrary.entity.CategoryResponse
import com.example.mylibrary.entity.MealDetails
import com.example.mylibrary.entity.MealsResponse
import com.example.mylibrary.repo.Repo

class MealsRepoImpl(private val apiService: ApiService) : Repo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
    override suspend fun getCatMealsFromRemote(cat: String): MealsResponse =
        apiService.getCatMeals(cat)

    override suspend fun getMealDetailsFromRemote(id: String): MealDetails =
        apiService.getMealDetails(id)
}