package com.rarecrew.myapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.rarecrew.myapplication.models.RecipeModel

class RecipeListRepository {

    companion object {
        var instance : RecipeListRepository? = null

        @JvmName("getInstance1")
        fun getInstance() : RecipeListRepository? {
            if(instance == null) {
                instance = RecipeListRepository()
            }

            return instance
        }
    }

    private val dataSet = arrayListOf<RecipeModel>()

    fun getRecipe(): MutableLiveData<List<RecipeModel>> {
        setRecipe()
        val mutableLiveData : MutableLiveData<List<RecipeModel>> = MutableLiveData()
        mutableLiveData.value = dataSet
        return mutableLiveData
    }

    private fun setRecipe() {
        dataSet.clear()
        for (i in 0 until 10) {
            val rm = RecipeModel("Name $i", "Description $i")
            dataSet.add(rm)
        }
    }
}