package com.rarecrew.myapplication.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rarecrew.myapplication.Models.RecipeModel
import com.rarecrew.myapplication.R
import com.rarecrew.myapplication.ViewModels.RecipeListViewModel
import com.rarecrew.myapplication.Views.Adapter.RecipeListAdapter

class RecipeListFragment : Fragment(), RecipeListAdapter.Interaction {

    lateinit var rootView: View

    private lateinit var recipeItemViewModel: RecipeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_recipe_list, container, false)

        recipeItemViewModel = ViewModelProvider(requireActivity()).get(RecipeListViewModel::class.java)

        recipeItemViewModel.setData()

        val adapter = RecipeListAdapter(this)

        val rv = rootView.findViewById<RecyclerView>(R.id.recipeRV)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter

        recipeItemViewModel.getRecipeList()?.observe(this.viewLifecycleOwner, {
            val data = recipeItemViewModel.getRecipeList()

            print(data)

            adapter.submitList(data?.value.orEmpty())
        })

        return rootView
    }

    override fun onItemSelected(position: Int, item: RecipeModel) {
        toast(item.name)
    }

    private fun toast(text: String?) {
        Toast.makeText(context!!, text.orEmpty(), Toast.LENGTH_SHORT).show()
    }
}