package com.mbobiosio.moviesboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.moviesboard.databinding.ItemCastBinding
import com.mbobiosio.moviesboard.model.cast.Cast

class CastsAdapter(
    val castListener: (Cast) -> Unit
) : ListAdapter<Cast, CastsAdapter.CastsAdapterVH>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<Cast>() {

        override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
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

        fun bind(cast: Cast) = with(itemView) {
            binding.cast = cast
            binding.executePendingBindings()

            setOnClickListener {
                castListener.invoke(cast)
            }
        }
    }
}