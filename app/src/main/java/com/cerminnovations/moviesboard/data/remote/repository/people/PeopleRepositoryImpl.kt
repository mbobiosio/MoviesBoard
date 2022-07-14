package com.cerminnovations.moviesboard.data.remote.repository.people

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.domain.repository.people.PeopleRepository
import com.cerminnovations.moviesboard.data.mappers.PeopleMapper
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import com.cerminnovations.moviesboard.data.remote.paging.people.PeopleMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class PeopleRepositoryImpl
@Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase,
    private val peopleMediator: PeopleMediator,
    private val mapper: PeopleMapper
) : PeopleRepository {

    override fun getPeople(): Flow<PagingData<Person>> {
        val pagingSourceFactory = database.peopleDao::getPeople

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = peopleMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { people ->
                people.mapEntityToDomain()
            }
        }
    }

    override suspend fun getPersonInfo(
        personId: Long?,
        apiKey: String?,
        appendToResponse: String?
    ): PersonInfo {
        val data = service.getArtistById(personId, apiKey, appendToResponse)
        return mapper.map(data)
    }
}
