package com.cerminnovations.moviesboard.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.cerminnovations.core.util.executeAfter
import com.cerminnovations.domain.model.video.Video
import com.cerminnovations.moviesboard.databinding.ItemVideoBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class VideoAdapter {

    inner class VideoViewHolder(
        private val binding: ItemVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Video) {
            binding.executeAfter {
            }
        }
    }
}
