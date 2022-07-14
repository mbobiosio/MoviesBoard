package com.cerminnovations.domain.model.people

import com.cerminnovations.domain.model.cast.MovieCast
import com.cerminnovations.domain.model.cast.TvCast

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class PersonInfo(
    val id: Int?,
    val name: String?,
    val birthday: String?,
    val gender: Int?,
    val knownForDepartment: String?,
    val deathDay: String?,
    val biography: String?,
    val popularity: Double?,
    val placeOfBirth: String?,
    val profilePath: String?,
    val isAdult: Boolean?,
    val imdbId: String?,
    val homepage: String?,
    val alsoKnownAs: List<String>?,

    // append to response
    val movieCredits: MovieCredit?,
    val seriesCredits: TvCredit?
) {
    data class MovieCredit(
        val id: Int?,
        val cast: List<MovieCast>?
    )

    data class TvCredit(
        val id: Int?,
        val cast: List<TvCast>?
    )
}
