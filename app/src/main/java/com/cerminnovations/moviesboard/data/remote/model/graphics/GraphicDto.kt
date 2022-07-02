package com.cerminnovations.moviesboard.data.remote.model.graphics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GraphicDto(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "backdrops")
    val backdrops: List<GraphicDetails>,

    @Json(name = "posters")
    val posters: List<GraphicDetails>

)
