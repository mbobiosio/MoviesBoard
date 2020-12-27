package com.mbobiosio.moviesboard.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.mbobiosio.moviesboard.service.GlideApp

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
const val BACKDROP_SIZE_780 = IMAGE_BASE_URL + "w780"

@BindingAdapter("bindImage")
fun AppCompatImageView.bindImage(url: String?) {
    url?.let {
        GlideApp.with(context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("bindBackdropImage")
fun AppCompatImageView.bindBackdropImage(url: String?) {
    url?.let {
        bindImage(BACKDROP_SIZE_780.plus(url))
    }
}