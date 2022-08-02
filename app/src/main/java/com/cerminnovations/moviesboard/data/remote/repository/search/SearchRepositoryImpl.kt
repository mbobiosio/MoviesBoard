package com.cerminnovations.moviesboard.data.remote.repository.search

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.domain.repository.search.SearchRepository
import com.cerminnovations.moviesboard.data.mappers.mapToDomain
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import com.cerminnovations.moviesboard.data.remote.paging.search.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class SearchRepositoryImpl @Inject constructor(
    private val service: ApiService
) : SearchRepository {

    override fun doMultiSearch(query: String, includeAdult: Boolean): Flow<PagingData<SearchResult>> {
        val pagingSourceFactory = { SearchDataSource(service, query, includeAdult) }

        return Pager(
            config = defaultPageConfig(),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { search ->
                search.mapToDomain()
            }
        }
    }
}
