package com.cerminnovations.moviesboard.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.cerminnovations.moviesboard.service.GlideApp

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
const val BACKDROP_SIZE_780 = IMAGE_BASE_URL + "w780"
const val PROFILE_SIZE_185 = IMAGE_BASE_URL + "w185"

@BindingAdapter("setImage")
fun AppCompatImageView.setImage(url: String?) {
    url?.let {
        GlideApp.with(context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("backdropImage")
fun AppCompatImageView.backdropImage(url: String?) {
    url?.let {
        setImage(BACKDROP_SIZE_780.plus(url))
    }
}

@BindingAdapter("moviePoster")
fun AppCompatImageView.moviePoster(url: String?) {
    url?.let {
        setImage(BACKDROP_SIZE_780.plus(url))
    }
}

@BindingAdapter("castImage")
fun AppCompatImageView.castImage(imagePath: String?) {
    imagePath?.let {
        setImage(PROFILE_SIZE_185 + imagePath)
    }
}
