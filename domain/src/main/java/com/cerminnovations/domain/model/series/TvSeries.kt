package com.cerminnovations.domain.model.series

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Parcelize
data class TvSeries(
    val tvId: Long,
    val name: String,
    val posterPath: String?,
    val popularity: Double,
    val backdropPath: String?,
    val voteAverage: Double,
    val overview: String,
    val firstAirDate: String?,
    val originCountry: List<String>,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val voteCount: Int,
    val originalName: String
) : Parcelable
