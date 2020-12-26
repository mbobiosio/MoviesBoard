package com.mbobiosio.moviesboard.model.graphics

import com.squareup.moshi.Json

data class Avatar(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "profiles")
    val profiles: List<GraphicDetails>

)
