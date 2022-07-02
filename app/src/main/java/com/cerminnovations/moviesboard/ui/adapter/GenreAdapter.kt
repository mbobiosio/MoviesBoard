package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.GenreDto
import com.cerminnovations.moviesboard.databinding.ItemGenreBinding

class GenreAdapter : ListAdapter<GenreDto, GenreAdapter.GenreViewHolder>(GenreCallback()) {

    private class GenreCallback : DiffUtil.ItemCallback<GenreDto>() {
        override fun areItemsTheSame(oldItem: GenreDto, newItem: GenreDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GenreDto, newItem: GenreDto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class GenreViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genreDto: GenreDto) {
            binding.genre = genreDto
            binding.executePendingBindings()
        }
    }
}
