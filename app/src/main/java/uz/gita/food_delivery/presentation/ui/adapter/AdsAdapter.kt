package uz.gita.food_delivery.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.food_delivery.R
import uz.gita.food_delivery.data.model.AdsData
import uz.gita.food_delivery.databinding.ItemAdsBinding

class AdsAdapter : ListAdapter<AdsData, AdsAdapter.AdsViewHolder>(AdsDiffUtil) {

    private object AdsDiffUtil : DiffUtil.ItemCallback<AdsData>() {
        override fun areItemsTheSame(oldItem: AdsData, newItem: AdsData): Boolean =
            (oldItem.id == newItem.id)

        override fun areContentsTheSame(oldItem: AdsData, newItem: AdsData): Boolean =
            (oldItem == newItem)

    }

    inner class AdsViewHolder(private val binding: ItemAdsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            Glide.with(binding.root)
                .load(getItem(absoluteAdapterPosition).image)
                .into(binding.adsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        return AdsViewHolder(
            ItemAdsBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        holder.bind()
    }


}