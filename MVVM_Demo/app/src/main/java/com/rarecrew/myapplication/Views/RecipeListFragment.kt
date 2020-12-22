package com.rarecrew.myapplication.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rarecrew.myapplication.models.RecipeModel
import com.rarecrew.myapplication.R
import com.rarecrew.myapplication.RecipeItemClickListener
import com.rarecrew.myapplication.ViewModels.RecipeListViewModel
import com.rarecrew.myapplication.Views.Adapter.RecipeListAdapter
import com.rarecrew.myapplication.databinding.FragmentRecipeListBinding

class RecipeListFragment : Fragment(), RecipeItemClickListener {

    lateinit var rootView: View

    private lateinit var recipeItemViewModel: RecipeListViewModel
    lateinit var binding : FragmentRecipeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_list, container,false)
        rootView = binding.root

        recipeItemViewModel = ViewModelProvider(requireActivity()).get(RecipeListViewModel::class.java)


        recipeItemViewModel.setData()

        val adapter = RecipeListAdapter(context!!, arrayListOf())

        val rv = rootView.findViewById<RecyclerView>(R.id.recipeRV)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter

        recipeItemViewModel.getRecipeList()?.observe(this.viewLifecycleOwner, {
            val data = recipeItemViewModel.getRecipeList()

            data?.value.let {
                val item = ArrayList(it ?: arrayListOf())
                adapter.updateList(item)
            }
        })

        return rootView
    }

    override fun onRecipeClicked(position: Int, item: RecipeModel) {
        toast(item.name)
    }

    private fun toast(text: String?) {
        Toast.makeText(context!!, text.orEmpty(), Toast.LENGTH_SHORT).show()
    }
}