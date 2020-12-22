package com.rarecrew.myapplication.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rarecrew.myapplication.models.RecipeModel
import com.rarecrew.myapplication.Repository.RecipeListRepository

class RecipeListViewModel : ViewModel() {

    private var recipeList: MutableLiveData<List<RecipeModel>>? = null

    private var mRepo : RecipeListRepository? = null

    fun setData() {
        if(recipeList == null) {
            mRepo = RecipeListRepository.getInstance()
            recipeList = mRepo?.getRecipe()
        }
    }

    fun getRecipeList(): LiveData<List<RecipeModel>>? {
        return recipeList
    }
}