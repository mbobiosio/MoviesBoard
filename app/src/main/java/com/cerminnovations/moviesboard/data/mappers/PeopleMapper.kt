package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.core.base.Mapper
import com.cerminnovations.database.entities.people.PeopleEntity
import com.cerminnovations.domain.model.cast.MovieCast
import com.cerminnovations.domain.model.cast.TvCast
import com.cerminnovations.domain.model.graphics.Profiles
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.domain.model.response.ListResponse
import com.cerminnovations.moviesboard.data.remote.model.artists.Artist
import com.cerminnovations.moviesboard.data.remote.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.data.remote.model.cast.SeriesCastDto
import com.cerminnovations.moviesboard.data.remote.model.graphics.AvatarDto
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun BaseResponse<Artist>.mapDataToEntity(): ListResponse<PeopleEntity> =
    with(this) {
        ListResponse(
            page = page,
            totalPages = totalPages,
            totalResults = totalResults,
            results = results.map {
                PeopleEntity(
                    it.id,
                    it.profilePath,
                    it.name,
                    it.popularity,
                    it.knownForDepartment
                )
            }
        )
    }

fun PeopleEntity.mapEntityToDomain(): Person =
    with(this) {
        Person(
            id = id,
            profilePath = profilePath,
            name = name,
            popularity = popularity,
            knownForDepartment = knownForDepartment
        )
    }

class PeopleMapper @Inject constructor() : Mapper<ArtistInfo, PersonInfo> {
    override fun map(input: ArtistInfo) = PersonInfo(
        id = input.id,
        name = input.name,
        birthday = input.birthday,
        gender = input.gender,
        knownForDepartment = input.knownForDepartment,
        deathDay = input.deathday,
        biography = input.biography,
        popularity = input.popularity,
        placeOfBirth = input.placeOfBirth,
        profilePath = input.profilePath,
        isAdult = input.adult,
        imdbId = input.imdbId,
        homepage = input.homepage,
        alsoKnownAs = input.alsoKnownAs,
        movieCredits = input.movieCredits?.mapDataToDomain(),
        seriesCredits = input.seriesCredits?.mapDataToDomain(),
        images = input.profiles?.mapDataToDomain()
    )
}

fun AvatarDto.mapDataToDomain(): Profiles =
    with(this) {
        Profiles(
            profiles = profiles.map {
                it.mapDataToDomain()
            }
        )
    }

fun ArtistInfo.MovieCredits.mapDataToDomain(): PersonInfo.MovieCredit =
    with(this) {
        PersonInfo.MovieCredit(
            id = id,
            cast = cast?.map {
                it.mapDataToDomain()
            }
        )
    }

fun ArtistInfo.SeriesCredits.mapDataToDomain(): PersonInfo.TvCredit =
    with(this) {
        PersonInfo.TvCredit(
            id = id,
            cast = cast?.map {
                it.mapDataToDomain()
            }
        )
    }

fun MovieCastDto.mapDataToDomain(): MovieCast =
    with(this) {
        MovieCast(
            id,
            title,
            overview,
            character,
            posterPath,
            backdropPath,
            voteAverage,
            voteCount,
            adult,
            creditId,
            genreIds,
            originalLanguage,
            originalTitle,
            popularity,
            releaseDate,
            video
        )
    }

fun SeriesCastDto.mapDataToDomain(): TvCast =
    with(this) {
        TvCast(
            id,
            name,
            backdropPath,
            posterPath,
            character,
            overview,
            popularity,
            voteAverage,
            voteCount,
            creditId,
            episodeCount,
            firstAirDate,
            genreIds,
            originCountry,
            originalLanguage,
            originalName
        )
    }
