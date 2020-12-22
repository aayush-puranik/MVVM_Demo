package com.rarecrew.myapplication

import com.rarecrew.myapplication.models.RecipeModel

interface RecipeItemClickListener {
    fun onRecipeClicked(position: Int, item: RecipeModel)
}