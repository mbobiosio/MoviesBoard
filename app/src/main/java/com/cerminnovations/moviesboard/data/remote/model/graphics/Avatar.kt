package com.cerminnovations.moviesboard.data.remote.model.graphics

import com.squareup.moshi.Json

data class Avatar(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "profiles")
    val profiles: List<GraphicDetails>

)
