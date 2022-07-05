package com.cerminnovations.domain.model

import com.cerminnovations.domain.model.cast.Cast
import com.cerminnovations.domain.model.crew.Crew

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Credit(
    val id: Int?,
    val casts: List<Cast>,
    val crews: List<Crew>
)
