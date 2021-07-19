package com.cerminnovations.moviesboard.model.shows

import com.cerminnovations.moviesboard.model.cast.Cast
import com.cerminnovations.moviesboard.model.crew.Crew
import com.squareup.moshi.Json

data class EpisodeDetails(

    @Json(name = "air_date")
    val airData: String,
    @Json(name = "crew")
    val crew: List<Crew>,
    @Json(name = "episode_number")
    val episodeNumber: Int,
    @Json(name = "guest_stars")
    val cast: List<Cast>,
    @Json(name = "name")
    val name: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "production_code")
    val productionCode: String?,
    @Json(name = "season_number")
    val seasonNumber: Int,
    @Json(name = "still_path")
    val stillPath: String?,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)