package com.cerminnovations.moviesboard.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Parcelize
data class Genre(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
) : Parcelable
