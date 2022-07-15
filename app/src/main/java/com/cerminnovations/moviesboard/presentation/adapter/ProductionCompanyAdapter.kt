package com.cerminnovations.moviesboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.production.ProductionCompany
import com.cerminnovations.moviesboard.databinding.ItemProductionCompanyBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ProductionCompanyAdapter :
    ListAdapter<ProductionCompany, ProductionCompanyAdapter.ProductionCompanyViewHolder>(
        ItemComparator()
    ) {

    private class ItemComparator : DiffUtil.ItemCallback<ProductionCompany>() {
        override fun areItemsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ProductionCompany,
            newItem: ProductionCompany
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductionCompanyViewHolder {
        val binding =
            ItemProductionCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductionCompanyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductionCompanyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ProductionCompanyViewHolder(
        private val binding: ItemProductionCompanyBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductionCompany) {
            binding.executeAfter {
                company = item
            }
        }
    }
}
