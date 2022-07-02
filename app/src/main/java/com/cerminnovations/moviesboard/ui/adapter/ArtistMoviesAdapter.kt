package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.databinding.ItemMoviesCastBinding

class ArtistMoviesAdapter(private val clickListener: ((MovieCastDto) -> Unit)?) :
    ListAdapter<MovieCastDto, ArtistMoviesAdapter.ArtistMoviesVH>(MoviesCallback()) {

    private class MoviesCallback : DiffUtil.ItemCallback<MovieCastDto>() {
        override fun areItemsTheSame(oldItem: MovieCastDto, newItem: MovieCastDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieCastDto, newItem: MovieCastDto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistMoviesAdapter.ArtistMoviesVH {
        val binding =
            ItemMoviesCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistMoviesVH(binding)
    }

    override fun onBindViewHolder(holder: ArtistMoviesAdapter.ArtistMoviesVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ArtistMoviesVH(private val binding: ItemMoviesCastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieCast: MovieCastDto) = with(itemView) {
            binding.movies = movieCast
            binding.executePendingBindings()

            setOnClickListener {
                clickListener?.invoke(movieCast)
            }
        }
    }
}
