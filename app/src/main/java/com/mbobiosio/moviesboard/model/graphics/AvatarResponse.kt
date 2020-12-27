package com.mbobiosio.moviesboard.model.graphics

import com.squareup.moshi.Json

data class AvatarResponse(

    @Json(name = "profiles")
    val profiles: List<GraphicDetails>

)
