package com.cerminnovations.moviesboard.data.remote.model.artists

import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.data.remote.model.cast.SeriesCastDto
import com.cerminnovations.moviesboard.data.remote.model.crew.MovieCrewDto
import com.cerminnovations.moviesboard.data.remote.model.crew.SeriesCrewDto
import com.cerminnovations.moviesboard.data.remote.model.graphics.Avatar
import com.cerminnovations.moviesboard.data.remote.model.graphics.GraphicDetails
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.squareup.moshi.Json

data class ArtistInfo(

    @Json(name = "birthday")
    val birthday: String?,
    @Json(name = "known_for_department")
    val knownForDepartment: String?,
    @Json(name = "deathday")
    val deathday: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "also_known_as")
    val alsoKnownAs: List<String>?,
    @Json(name = "gender")
    val gender: Int?,
    @Json(name = "biography")
    val biography: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "place_of_birth")
    val placeOfBirth: String?,
    @Json(name = "profile_path")
    val profilePath: String?,
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "homepage")
    val homepage: String?,

    // append to response
    @Json(name = "movie_credits")
    val movieCredits: MovieCredits?,
    @Json(name = "tv_credits")
    val seriesCredits: SeriesCredits?,
    @Json(name = "images")
    val profileImages: Avatar?,
    @Json(name = "tagged_images")
    val backdrops: BaseResponse<GraphicDetails>?
) {
    data class MovieCredits(
        @Json(name = "id")
        val id: Int?,
        @Json(name = "cast")
        val cast: List<MovieCastDto>?,
        @Json(name = "crew")
        val crew: List<MovieCrewDto>?
    )

    data class SeriesCredits(
        @Json(name = "id")
        val id: Int?,
        @Json(name = "cast")
        val cast: List<SeriesCastDto>?,
        @Json(name = "crew")
        val crew: List<SeriesCrewDto>?
    )
}
