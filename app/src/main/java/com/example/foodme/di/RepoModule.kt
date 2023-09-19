package com.example.foodme.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.mylibrary.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(apiService: ApiService): Repo {
        return MealsRepoImpl(apiService)
    }
}