package com.cerminnovations.domain.model.series

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Parcelize
data class TvSeriesInfo(
    val id: Long?,
    val name: String?,
    val overview: String?,
    val type: String?,
    val backdropPath: String?,
    val posterPath: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val firstAirDate: String?,
    val lastAirDate: String?,
    val numberOfSeasons: Int?,
    val homepage: String?,
    val inProduction: Boolean,
    val popularity: Double?,
    val numberOfEpisodes: Int?,
    val status: String,
    val originalName: String,
    val originalLanguage: String,
    val episodeRunTime: List<Int>,
    val languages: List<String>,
    val originCountry: List<String>
) : Parcelable
