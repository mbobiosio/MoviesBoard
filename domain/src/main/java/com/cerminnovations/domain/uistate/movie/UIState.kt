package com.cerminnovations.domain.uistate.movie

import com.cerminnovations.domain.model.ErrorResponse
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
