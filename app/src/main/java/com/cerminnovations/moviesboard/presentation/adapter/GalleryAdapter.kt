package com.cerminnovations.moviesboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.graphics.ImageDetails
import com.cerminnovations.moviesboard.databinding.ItemGalleryBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class GalleryAdapter :
    ListAdapter<ImageDetails, GalleryAdapter.GalleryViewHolder>(ItemsComparator()) {

    private class ItemsComparator : DiffUtil.ItemCallback<ImageDetails>() {
        override fun areItemsTheSame(oldItem: ImageDetails, newItem: ImageDetails) =
            oldItem.voteCount == newItem.voteCount

        override fun areContentsTheSame(oldItem: ImageDetails, newItem: ImageDetails) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class GalleryViewHolder(
        private val binding: ItemGalleryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageDetails) {
            binding.executeAfter {
                image = item
            }
        }
    }
}
