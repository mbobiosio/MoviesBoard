package com.cerminnovations.moviesboard.data.remote.model.production

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCompanyDto(

    @Json(name = "id")
    val id: Int,

    @Json(name = "logo_path")
    val logoPath: String?,

    @Json(name = "name")
    val name: String,

    @Json(name = "origin_country")
    val originCountry: String
)
