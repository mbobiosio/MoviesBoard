package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResultDto
import com.cerminnovations.moviesboard.databinding.ItemSearchBinding

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class SearchAdapter(
    val listener: (SearchResultDto) -> Unit
) : PagingDataAdapter<SearchResultDto, SearchAdapter.MoviesViewHolder>(ListItemCallback()) {

    private class ListItemCallback : DiffUtil.ItemCallback<SearchResultDto>() {
        override fun areItemsTheSame(oldItem: SearchResultDto, newItem: SearchResultDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchResultDto, newItem: SearchResultDto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MoviesViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            searchResult: SearchResultDto
        ) = with(itemView) {
            binding.search = searchResult
            binding.executePendingBindings()

            setOnClickListener {
                listener.invoke(searchResult)
            }
        }
    }
}
