package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.databinding.ItemMovieBinding

class MovieAdapter :
    PagingDataAdapter<PopularMovie, MovieAdapter.MovieAdapterVH>(ListItemCallback()) {

    private class ListItemCallback : DiffUtil.ItemCallback<PopularMovie>() {
        override fun areItemsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
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

        fun bind(popularMovie: PopularMovie) = with(binding) {
            movie = popularMovie
            executePendingBindings()

            // setOnClickListener {
            // movieListener.invoke(movie)
            // }
        }
    }
}
