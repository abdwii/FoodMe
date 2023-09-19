package com.example.foodme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodme.databinding.ListItemBinding
import com.example.foodme.databinding.MealsItemBinding
import com.example.mylibrary.entity.Meal


class MealsCatAdapter(private val callBack: (String) -> Unit) :
    ListAdapter<Meal, MealsCatAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            MealsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: MealsItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(meal: Meal) {
            itemBinding.mealNameTv.text = meal.strMeal
            itemBinding.mealDescTv.text = meal.strMeal
            Glide.with(itemBinding.root.context).load(meal.strMealThumb)
                .into(itemBinding.mealImage)
            itemBinding.root.setOnClickListener {
                callBack(meal.idMeal)
            }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem == newItem
        }
    }
}