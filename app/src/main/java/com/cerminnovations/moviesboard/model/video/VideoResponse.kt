package com.cerminnovations.moviesboard.model.video

import com.squareup.moshi.Json

data class VideoResponse(

    @Json(name = "results")
    val results: List<Video>

)
