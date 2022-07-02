package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.shows.Series
import com.cerminnovations.moviesboard.databinding.ItemSeriesBinding

class SeriesAdapter(
    private val seriesClickListener: (Series) -> Unit
) : ListAdapter<Series, SeriesAdapter.SeriesViewHolder>(SeriesCallback()) {

    private class SeriesCallback : DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
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

    inner class SeriesViewHolder(private val seriesBinding: ItemSeriesBinding) :
        RecyclerView.ViewHolder(seriesBinding.root) {
        fun bind(series: Series) = with(itemView) {
            seriesBinding.series = series
            seriesBinding.executePendingBindings()

            setOnClickListener {
                seriesClickListener.invoke(series)
            }
        }
    }
}
