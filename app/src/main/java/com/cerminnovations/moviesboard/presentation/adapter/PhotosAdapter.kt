package com.cerminnovations.moviesboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.graphics.ImageDetails
import com.cerminnovations.moviesboard.databinding.ItemPhotosBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PhotosAdapter : ListAdapter<ImageDetails, PhotosAdapter.PhotosViewHolder>(ItemsComparator()) {

    private class ItemsComparator : DiffUtil.ItemCallback<ImageDetails>() {
        override fun areItemsTheSame(oldItem: ImageDetails, newItem: ImageDetails) =
            oldItem.voteCount == newItem.voteCount

        override fun areContentsTheSame(oldItem: ImageDetails, newItem: ImageDetails) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = ItemPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class PhotosViewHolder(
        private val binding: ItemPhotosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageDetails) {
            binding.executeAfter {
                image = item
                executePendingBindings()
            }
        }
    }
}
