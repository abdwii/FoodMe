package com.example.mylibrary.usecase

import com.example.mylibrary.repo.Repo

class GetMealDetails(private val repo: Repo) {
    suspend operator fun invoke(id: String) = repo.getMealDetailsFromRemote(id)
}