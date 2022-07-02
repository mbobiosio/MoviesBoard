package com.cerminnovations.moviesboard.presentation.movies

import com.cerminnovations.core.error.ErrorResponse
import com.cerminnovations.domain.model.movies.MovieDetail

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
sealed class UIState {
    object Loading : UIState()
    data class Error(val message: ErrorResponse? = null) : UIState()
    data class Success(val result: MovieDetail) : UIState()
}