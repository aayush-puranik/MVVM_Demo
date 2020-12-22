package com.rarecrew.myapplication.Repository

import androidx.lifecycle.MutableLiveData
import com.rarecrew.myapplication.models.RecipeModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class RecipeListRepository {

    companion object {
        var instance: RecipeListRepository? = null

        @JvmName("getInstance1")
        fun getInstance(): RecipeListRepository? {
            if (instance == null) {
                instance = RecipeListRepository()
            }

            return instance
        }
    }

    private val dataSet = arrayListOf<RecipeModel>()

    fun getRecipe(callback: (MutableLiveData<List<RecipeModel>>) -> Unit) {
        CoroutineScope(Main).launch {
            setRecipe {
                val mutableLiveData: MutableLiveData<List<RecipeModel>> = MutableLiveData()
                mutableLiveData.value = dataSet
                callback(mutableLiveData)
            }
        }
    }

    private suspend fun setRecipe(callback: (List<RecipeModel>) -> Unit) {
        CoroutineScope(Main).launch {
            dataSet.clear()

            delay(5000)

            for (i in 0 until 100) {
                val rm = RecipeModel("Name $i", "Description $i")
                dataSet.add(rm)
            }

            callback(dataSet)
        }
    }
}