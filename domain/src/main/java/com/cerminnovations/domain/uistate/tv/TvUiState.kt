package com.cerminnovations.domain.uistate.tv

import com.cerminnovations.domain.model.ErrorResponse
import com.cerminnovations.domain.model.series.TvSeriesInfo

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
sealed class TvUiState {
    object Loading : TvUiState()
    data class Error(val message: ErrorResponse? = null) : TvUiState()
    data class Success(val result: TvSeriesInfo) : TvUiState()
}
