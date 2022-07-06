package com.cerminnovations.moviesboard.presentation.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.moviesboard.databinding.ItemSeriesBinding

class SeriesAdapter :
    PagingDataAdapter<TvSeries, SeriesAdapter.SeriesViewHolder>(SeriesCallback()) {

    private class SeriesCallback : DiffUtil.ItemCallback<TvSeries>() {
        override fun areItemsTheSame(oldItem: TvSeries, newItem: TvSeries): Boolean {
            return oldItem.tvId == newItem.tvId
        }

        override fun areContentsTheSame(oldItem: TvSeries, newItem: TvSeries): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val binding = ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class SeriesViewHolder(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TvSeries) = with(binding) {
            binding.executeAfter {
                series = item
                executePendingBindings()
            }
        }
    }
}
