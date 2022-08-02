package com.cerminnovations.domain.repository.search

import androidx.paging.PagingData
import com.cerminnovations.domain.model.search.SearchResult
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface SearchRepository {
    fun doMultiSearch(query: String, includeAdult: Boolean): Flow<PagingData<SearchResult>>
}
