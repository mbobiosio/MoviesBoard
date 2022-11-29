package com.cerminnovations.moviesboard.util

import androidx.databinding.BindingAdapter
import com.cerminnovations.domain.model.Genre
import com.google.android.material.textview.MaterialTextView

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@BindingAdapter("genre")
fun MaterialTextView.genre(genres: List<Genre>?) {
    genres?.let {
        text = getGenre(genres)
    }
}

fun getGenre(ids: List<Genre>): String {
    var genre = ""
    ids.forEach {
        when (it.id) {
            12 -> genre += "Adventure | "
            14 -> genre += "Fantasy | "
            16 -> genre += "Animation | "
            18 -> genre += "Drama | "
            27 -> genre += "Horror | "
            28 -> genre += "Action | "
            35 -> genre += "Comedy | "
            36 -> genre += "History | "
            37 -> genre += "Western | "
            53 -> genre += "Thriller | "
            80 -> genre += "Crime | "
            99 -> genre += "Documentary | "
            878 -> genre += "Science Fiction | "
            9648 -> genre += "Mystery | "
            10402 -> genre += "Music | "
            10749 -> genre += "Romance | "
            10751 -> genre += "Family | "
            10752 -> genre += "War | "
            10770 -> genre += "TV Movie | "
            else -> genre += "Unresolved symbol"
        }
    }
    when {
        genre != "" -> genre = genre.substring(0, genre.length - 2)
    }

    return genre
}
