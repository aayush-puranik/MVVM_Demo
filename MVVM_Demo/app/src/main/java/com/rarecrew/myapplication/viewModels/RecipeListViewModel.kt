package com.rarecrew.myapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rarecrew.myapplication.models.RecipeModel
import com.rarecrew.myapplication.Repository.RecipeListRepository

class RecipeListViewModel : ViewModel() {

    val recipeList: MutableLiveData<List<RecipeModel>> by lazy {
        MutableLiveData<List<RecipeModel>>()
    }

    private var mRepo: RecipeListRepository? = null

    fun setData() {
        mRepo = RecipeListRepository.getInstance()
        mRepo?.getRecipe {
            recipeList.value = it.value
        }
    }

    fun getRecipeList(): LiveData<List<RecipeModel>>? {
        return recipeList
    }
}