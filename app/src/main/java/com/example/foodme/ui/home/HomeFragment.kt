package com.example.foodme.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.foodme.MealsAdapter
import com.example.foodme.MealsCatAdapter
import com.example.foodme.MealsViewModel
import com.example.foodme.R
import com.example.foodme.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var mealsViewModel: MealsViewModel
    private lateinit var mealsAdapter: MealsAdapter
    private lateinit var mealsCatAdapter: MealsCatAdapter
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mealsViewModel = ViewModelProvider(this)[MealsViewModel::class.java]

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        init()
        lifecycleScope.launch {
            mealsViewModel.categories.collect {
                withContext(Dispatchers.Main) {
                    mealsAdapter.submitList(it?.categories)
                    binding.rv.adapter = mealsAdapter
                }

            }
        }
    }

    private fun init() {
        mealsAdapter = MealsAdapter {
            mealsViewModel.getCatMeals(it)
            lifecycleScope .launch {
                mealsViewModel.meals.collect {
                    withContext(Dispatchers.Main) {
                        mealsCatAdapter.submitList(it?.meals)
                        binding.rv2.adapter = mealsCatAdapter
                    }

                }
            }
        }
        mealsCatAdapter = MealsCatAdapter {
            findNavController().navigate(
                R.id.action_homeFragment_to_detailsFragment,
                args = Bundle().apply {
                    putString("ID", it)
                })
        }
        mealsViewModel.getMeals()


    }

}