package com.cerminnovations.moviedetail.mapper

import com.cerminnovations.core.error.ErrorMessage
import com.cerminnovations.domain.model.ErrorResponse

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun ErrorMessage.mapDataToDomain(): ErrorResponse =
    with(this) {
        ErrorResponse(
            errorMessage = errorMessage
        )
    }
