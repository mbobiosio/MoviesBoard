package com.cerminnovations.moviesboard.presentation.movies.interfaces

import com.cerminnovations.domain.model.MovieData

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface MovieItemClickListener {
    fun onItemClick(movieData: MovieData)
}
