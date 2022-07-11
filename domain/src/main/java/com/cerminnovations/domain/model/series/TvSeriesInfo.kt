package com.cerminnovations.domain.model.series

import com.cerminnovations.domain.model.Credit
import com.cerminnovations.domain.model.graphics.Images
import com.cerminnovations.domain.model.video.VideoResponse

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */

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
    val originCountry: List<String>,
    val images: Images?,
    val credits: Credit?,
    val videoResponse: VideoResponse?
)
