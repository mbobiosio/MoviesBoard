package com.cerminnovations.moviesboard.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.databinding.ItemMovieBinding
import com.cerminnovations.moviesboard.domain.model.MovieData

class MovieAdapter :
    PagingDataAdapter<MovieData, MovieAdapter.MovieAdapterVH>(ItemComparator()) {

    private class ItemComparator : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterVH {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapterVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MovieAdapterVH(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(popularMovie: MovieData) = with(binding) {
            movie = popularMovie
            executePendingBindings()
        }
    }
}
