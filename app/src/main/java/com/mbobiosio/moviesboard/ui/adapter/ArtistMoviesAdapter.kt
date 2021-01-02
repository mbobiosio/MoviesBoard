package com.mbobiosio.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.moviesboard.databinding.ItemArtistMoviesBinding
import com.mbobiosio.moviesboard.model.cast.MovieCast

class ArtistMoviesAdapter(private val clickListener: ((MovieCast) -> Unit)?) :
    ListAdapter<MovieCast, ArtistMoviesAdapter.ArtistMoviesVH>(MoviesCallback()) {

    private class MoviesCallback : DiffUtil.ItemCallback<MovieCast>() {
        override fun areItemsTheSame(oldItem: MovieCast, newItem: MovieCast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieCast, newItem: MovieCast): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistMoviesAdapter.ArtistMoviesVH {
        val binding =
            ItemArtistMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistMoviesVH(binding)
    }

    override fun onBindViewHolder(holder: ArtistMoviesAdapter.ArtistMoviesVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ArtistMoviesVH(private val binding: ItemArtistMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieCast: MovieCast) = with(itemView) {
            binding.movieCast = movieCast
            binding.executePendingBindings()

            setOnClickListener {
                clickListener?.invoke(movieCast)
            }
        }
    }
}