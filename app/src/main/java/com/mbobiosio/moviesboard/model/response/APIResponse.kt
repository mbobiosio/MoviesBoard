package com.mbobiosio.moviesboard.model.response

import com.mbobiosio.moviesboard.model.Genre
import com.squareup.moshi.Json

class APIResponse(

    @Json(name = "genres")
    val genres: List<Genre>,

    @Json(name = "status_message")
    val errorMessage: String?,

    @Json(name = "status_code")
    val errorCode: Int?

)