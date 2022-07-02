package com.cerminnovations.moviesboard.data.remote.model.video

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoResponseDto(

    @Json(name = "results")
    val results: List<VideoDto>
)
