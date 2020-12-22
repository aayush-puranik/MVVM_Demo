package com.rarecrew.myapplication.views.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rarecrew.myapplication.R
import com.rarecrew.myapplication.databinding.CellRecipeListBinding
import com.rarecrew.myapplication.models.RecipeModel

class RecipeListAdapter(
    var list: ArrayList<RecipeModel>
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(private val binding: CellRecipeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecipeModel) {
            binding.data = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CellRecipeListBinding = DataBindingUtil.inflate(inflater, R.layout.cell_recipe_list, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(list[position])

    fun submitList(updateList : ArrayList<RecipeModel>) {
        this.list = updateList
        notifyDataSetChanged()
    }
}