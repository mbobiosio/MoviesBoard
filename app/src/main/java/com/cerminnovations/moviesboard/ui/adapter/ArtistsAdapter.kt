package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.databinding.ItemArtistBinding
import com.cerminnovations.moviesboard.model.artists.Artist

class ArtistsAdapter(private val artistListener: (Artist) -> Unit) :
    PagingDataAdapter<Artist, ArtistsAdapter.ArtistViewHolder>(ArtistCallback()) {

    private class ArtistCallback : DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsAdapter.ArtistViewHolder {
        val binding = ItemArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsAdapter.ArtistViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ArtistViewHolder(private val binding: ItemArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) = with(itemView) {
            binding.artist = artist
            binding.executePendingBindings()

            setOnClickListener {
                artistListener.invoke(artist)
            }
        }
    }
}