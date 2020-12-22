package com.rarecrew.myapplication.Views.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rarecrew.myapplication.models.RecipeModel
import com.rarecrew.myapplication.databinding.CellRecipeListBinding

class RecipeListAdapter(val context: Context,
                        var list: ArrayList<RecipeModel>
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {


    inner class RecipeViewHolder(private val binding: CellRecipeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecipeModel) {
            with(binding) {
                this.data = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CellRecipeListBinding.inflate(inflater)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.count()

    fun updateList(updatedList: ArrayList<RecipeModel>) {
        this.list = updatedList
        notifyDataSetChanged()
    }
}