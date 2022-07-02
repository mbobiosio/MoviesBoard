package com.cerminnovations.moviesboard.data.remote.model.shows

import com.cerminnovations.moviesboard.data.remote.model.Credits
import com.cerminnovations.moviesboard.data.remote.model.GenreDto
import com.cerminnovations.moviesboard.data.remote.model.graphics.GraphicDto
import com.cerminnovations.moviesboard.data.remote.model.production.ProductionCompanyDto
import com.cerminnovations.moviesboard.data.remote.model.video.VideoResponseDto
import com.squareup.moshi.Json

data class SeriesDetails(

    @Json(name = "backdrop_path")
    val backdropPath: String?,

    @Json(name = "created_by")
    val createdBy: List<CreatedBy>,

    @Json(name = "episode_run_time")
    val episodeRunTime: List<Int>,

    @Json(name = "first_air_date")
    val firstAirDate: String?,

    @Json(name = "genres")
    val genreDtos: List<GenreDto>,

    @Json(name = "homepage")
    val homepage: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "in_production")
    val inProduction: Boolean,

    @Json(name = "languages")
    val languages: List<String>,

    @Json(name = "last_air_date")
    val lastAirDate: String?,

    @Json(name = "last_episode_to_air")
    val episodeToAir: EpisodeToAir?,

    @Json(name = "name")
    val name: String,

    @Json(name = "networks")
    val networks: List<Network>,

    @Json(name = "next_episode_to_air")
    val nextEpisodeToAir: EpisodeToAir?,

    @Json(name = "number_of_episodes")
    val numberOfEpisodes: Int,

    @Json(name = "number_of_seasons")
    val numberOfSeasons: Int,

    @Json(name = "origin_country")
    val originCountry: List<String>,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "original_name")
    val originalName: String,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "popularity")
    val popularity: Double,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDto>,

    @Json(name = "seasons")
    val seasons: List<Season>,

    @Json(name = "status")
    val status: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "vote_average")
    val voteAverage: Double,

    @Json(name = "vote_count")
    val voteCount: Int,

    // append to response
    @Json(name = "images")
    val images: GraphicDto,

    @Json(name = "credits")
    val credits: Credits,

    @Json(name = "videos")
    val videoResponse: VideoResponseDto
) {
    data class CreatedBy(
        @Json(name = "id")
        val id: Int,

        @Json(name = "credit_id")
        val creditId: String,

        @Json(name = "name")
        val name: String,

        @Json(name = "gender")
        val gender: Int?,

        @Json(name = "profile_path")
        val profilePath: String?
    )

    data class EpisodeToAir(
        @Json(name = "air_date")
        val airDate: String,

        @Json(name = "episode_number")
        val episodeNumber: Int,

        @Json(name = "id")
        val id: Int,

        @Json(name = "name")
        val name: String,

        @Json(name = "overview")
        val overview: String,

        @Json(name = "production_code")
        val productionCode: String,

        @Json(name = "season_number")
        val seasonNumber: Int,

        @Json(name = "still_path")
        val stillPath: String?,

        @Json(name = "vote_average")
        val voteAverage: Double,

        @Json(name = "vote_count")
        val voteCount: Int
    )

    data class Network(
        @Json(name = "name")
        val name: String,

        @Json(name = "id")
        val id: Int,

        @Json(name = "logo_path")
        val logoPath: String?,

        @Json(name = "origin_country")
        val originCountry: String
    )

    data class Season(
        @Json(name = "air_date")
        val airDate: String?,

        @Json(name = "episode_count")
        val episodeCount: Int,

        @Json(name = "id")
        val id: Int,

        @Json(name = "name")
        val name: String,

        @Json(name = "overview")
        val overview: String?,

        @Json(name = "poster_path")
        val posterPath: String?,

        @Json(name = "season_number")
        val seasonNumber: Int
    )
}
