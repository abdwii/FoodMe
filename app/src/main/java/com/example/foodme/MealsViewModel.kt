package com.example.foodme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibrary.entity.CategoryResponse
import com.example.mylibrary.entity.MealDetails
import com.example.mylibrary.entity.MealsResponse
import com.example.mylibrary.usecase.GetCatMeals
import com.example.mylibrary.usecase.GetMealDetails
import com.example.mylibrary.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals,
    private val getCatMealsUseCase: GetCatMeals,
    private val getMealDetailsUseCase: GetMealDetails,
) : ViewModel() {
    private val TAG: String = "MEALS"
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoryResponse?> = _categories
    private val _meals: MutableStateFlow<MealsResponse?> = MutableStateFlow(null)
    val meals: StateFlow<MealsResponse?> = _meals
    private val _mealDetails: MutableStateFlow<MealDetails?> = MutableStateFlow(null)
    val mealDetails: StateFlow<MealDetails?> = _mealDetails

    fun getMeals() {
        try {
            viewModelScope.launch {
                _categories.emit(getMealsUseCase())
                Log.d(TAG, "getMeals: ${getMealsUseCase().categories}")
            }

        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    fun getCatMeals(cat: String) {
        try {
            viewModelScope.launch {
                _meals.emit( getCatMealsUseCase(cat))
            }

        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    fun getMealDetails(id: String) {
        try {
            viewModelScope.launch {
                _mealDetails.emit(getMealDetailsUseCase(id))
            }

        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

}