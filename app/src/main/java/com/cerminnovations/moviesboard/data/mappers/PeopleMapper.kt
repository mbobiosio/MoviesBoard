package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.database.entities.people.PeopleEntity
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.model.response.ListResponse
import com.cerminnovations.moviesboard.data.remote.model.artists.Artist
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse

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
/*

class PeopleMapper @Inject constructor() : Mapper<Artist, PeopleEntity> {
    override fun map(input: Artist) = PeopleEntity(
        id = input.id,
        profilePath = input.profilePath,
        name = input.name,
        popularity = input.popularity,
        knownForDepartment = input.knownForDepartment
    )
}
*/
