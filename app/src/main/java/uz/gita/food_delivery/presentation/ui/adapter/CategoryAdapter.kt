package uz.gita.food_delivery.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.food_delivery.R
import uz.gita.food_delivery.data.model.CategoriesData
import uz.gita.food_delivery.databinding.ItemCategoryBinding

class CategoryAdapter :
    ListAdapter<CategoriesData, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtil) {

    private object CategoryDiffUtil : DiffUtil.ItemCallback<CategoriesData>() {
        override fun areItemsTheSame(oldItem: CategoriesData, newItem: CategoriesData): Boolean =
            (oldItem.id == newItem.id)

        override fun areContentsTheSame(oldItem: CategoriesData, newItem: CategoriesData): Boolean =
            (oldItem == newItem)
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind() {
            binding.categoryFoodName.text = getItem(absoluteAdapterPosition).name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_category, parent, false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind()
    }
}