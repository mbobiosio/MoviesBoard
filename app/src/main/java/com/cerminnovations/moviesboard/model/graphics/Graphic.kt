package com.cerminnovations.moviesboard.model.graphics

import com.squareup.moshi.Json

data class Graphic(

    @Json(name = "id") val id: Int?,
    @Json(name = "backdrops") val backdrops: List<GraphicDetails>,
    @Json(name = "posters") val posters: List<GraphicDetails>

)
