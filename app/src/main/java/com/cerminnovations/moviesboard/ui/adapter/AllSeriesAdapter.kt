package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.shows.Series
import com.cerminnovations.moviesboard.databinding.ItemSeriesBinding

class AllSeriesAdapter(
    val listener: (Series) -> Unit
) : PagingDataAdapter<Series, AllSeriesAdapter.AllSeriesVH>(ListItemCallback()) {

    private class ListItemCallback : DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllSeriesVH {
        val binding = ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllSeriesVH(binding)
    }

    override fun onBindViewHolder(holder: AllSeriesVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class AllSeriesVH(private val binding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            series: Series
        ) = with(itemView) {
            binding.series = series
            binding.executePendingBindings()

            setOnClickListener {
                listener.invoke(series)
            }
        }
    }
}
