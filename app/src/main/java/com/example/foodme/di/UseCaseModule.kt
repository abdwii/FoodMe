package com.example.foodme.di

import com.example.mylibrary.repo.Repo
import com.example.mylibrary.usecase.GetCatMeals
import com.example.mylibrary.usecase.GetMealDetails
import com.example.mylibrary.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(repo: Repo): GetMeals {
        return GetMeals(repo)
    }

    @Provides
    fun provideMealsUseCase(repo: Repo): GetCatMeals {
        return GetCatMeals(repo)
    }

    @Provides
    fun provideMealDetailsUseCase(repo: Repo): GetMealDetails {
        return GetMealDetails(repo)
    }
}