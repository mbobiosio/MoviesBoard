package com.cerminnovations.moviesboard.data.remote.model.graphics

import com.squareup.moshi.Json

data class AvatarDto(

    @Json(name = "profiles")
    val profiles: List<GraphicDetails>

)
