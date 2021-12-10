package br.com.angelcomp.themeal.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.angelcomp.themeal.databinding.ItemCategoryBinding
import br.com.angelcomp.themeal.presenter.model.CategoryUiModel
import coil.load

class CategoriesAdapter(
    private val listener: OnItemClickListener,
    private val categories: List<CategoryUiModel>
): RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemView)
    }

    interface OnItemClickListener {
        fun viewFavoriteDetails(position: Int)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]

        with(holder) {
            binding.tvMeal.text = category.name
            binding.ivMeal.load(category.thumb)
        }

        holder.itemView.setOnClickListener {
            listener.viewFavoriteDetails(position)
        }
    }

    override fun getItemCount() = categories.size

    inner class CategoriesViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)
}