package com.cerminnovations.moviesboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.review.Review
import com.cerminnovations.moviesboard.databinding.ItemReviewsBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ReviewsAdapter :
    PagingDataAdapter<Review, ReviewsAdapter.ReviewsViewHolder>(ItemsComparator()) {

    private class ItemsComparator : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Review, newItem: Review) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val binding = ItemReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding(it)
        }
    }

    inner class ReviewsViewHolder(
        private val binding: ItemReviewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun binding(item: Review) {
            binding.executeAfter {
                review = item
            }
        }
    }
}
