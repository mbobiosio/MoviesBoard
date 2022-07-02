package com.cerminnovations.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.moviesboard.data.remote.model.cast.CastDto
import com.cerminnovations.moviesboard.databinding.ItemCastBinding

class CastsAdapter(
    val castListener: (CastDto) -> Unit
) : ListAdapter<CastDto, CastsAdapter.CastsAdapterVH>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<CastDto>() {

        override fun areItemsTheSame(oldItem: CastDto, newItem: CastDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CastDto, newItem: CastDto): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastsAdapterVH {
        val binding = ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastsAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: CastsAdapterVH, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class CastsAdapterVH(private val binding: ItemCastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cast: CastDto) = with(itemView) {
            binding.cast = cast
            binding.executePendingBindings()

            setOnClickListener {
                castListener.invoke(cast)
            }
        }
    }
}
