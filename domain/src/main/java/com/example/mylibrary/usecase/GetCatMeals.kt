package com.example.mylibrary.usecase

import com.example.mylibrary.repo.Repo

class GetCatMeals(private val repo: Repo) {
    suspend operator fun invoke(cat: String) = repo.getCatMealsFromRemote(cat)
}