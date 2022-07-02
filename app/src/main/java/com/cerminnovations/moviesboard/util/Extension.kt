package com.cerminnovations.moviesboard.util

import androidx.paging.PagingConfig
import com.cerminnovations.core.constant.Constants.DEFAULT_PAGE_SIZE
import com.cerminnovations.moviesboard.data.remote.model.GenreDto
import com.cerminnovations.moviesboard.service.MovieType
import com.cerminnovations.moviesboard.service.SeriesType

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
val DEFAULT_MOVIES_TYPE = MovieType.POPULAR
val DEFAULT_SERIES_TYPE = SeriesType.POPULAR
const val IMDB_URL = "https://imdb.com/name/"

fun getGenre(ids: List<GenreDto>): String {
    var genre = ""
    ids.forEach {
        when (it.id) {
            28 -> genre += "Action | "
            12 -> genre += "Adventure | "
            16 -> genre += "Animation | "
            35 -> genre += "Comedy | "
            80 -> genre += "Crime | "
            99 -> genre += "Documentary | "
            18 -> genre += "Drama |"
            10751 -> genre += "Family | "
            14 -> genre += "Fantasy | "
            36 -> genre += "History | "
            27 -> genre += "Horror | "
            10402 -> genre += "Music | "
            9648 -> genre += "Mystery | "
            10749 -> genre += "Romance | "
            878 -> genre += "Science Fiction | "
            10770 -> genre += "TV Movie | "
            53 -> genre += "Thriller | "
            10752 -> genre += "War | "
            37 -> genre += "Western | "
            else -> genre += "Unresolved symbol"
        }
    }
    when {
        genre != "" -> genre = genre.substring(0, genre.length - 2)
    }

    return genre
}

fun defaultPageConfig(): PagingConfig =
    PagingConfig(
        pageSize = DEFAULT_PAGE_SIZE,
        enablePlaceholders = true,
        prefetchDistance = 5,
        initialLoadSize = 40
    )
