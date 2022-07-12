package com.cerminnovations.moviesboard.data.remote.repository.people

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.repository.people.PeopleRepository
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
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
    private val database: AppDatabase,
    private val peopleMediator: PeopleMediator
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
}
