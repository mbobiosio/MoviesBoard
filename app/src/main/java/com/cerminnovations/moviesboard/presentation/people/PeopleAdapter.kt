package com.cerminnovations.moviesboard.presentation.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.moviesboard.databinding.ItemArtistBinding

class PeopleAdapter :
    PagingDataAdapter<Person, PeopleAdapter.ArtistViewHolder>(ArtistCallback()) {

    private class ArtistCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistViewHolder {
        val binding = ItemArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ArtistViewHolder(private val binding: ItemArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Person) = with(itemView) {
            binding.executeAfter {
                person = item
                executePendingBindings()
            }
        }
    }
}
