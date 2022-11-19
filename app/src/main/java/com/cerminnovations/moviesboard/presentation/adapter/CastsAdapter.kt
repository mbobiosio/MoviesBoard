package com.cerminnovations.moviesboard.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.listeners.CastItemClickListener
import com.cerminnovations.domain.model.cast.Cast
import com.cerminnovations.moviesboard.databinding.ItemCastBinding

class CastsAdapter : ListAdapter<Cast, CastsAdapter.CastsAdapterVH>(ItemCallback()) {
    lateinit var castItemClickListener: CastItemClickListener

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

        fun bind(castItem: Cast) {
            binding.executeAfter {
                cast = castItem
                clickListener = castItemClickListener
                executePendingBindings()
            }
        }
    }
}
