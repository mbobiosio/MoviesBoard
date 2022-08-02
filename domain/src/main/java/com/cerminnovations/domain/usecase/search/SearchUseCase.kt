package com.cerminnovations.domain.usecase.search

import androidx.paging.PagingData
import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.domain.repository.search.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) {
    operator fun invoke(query: String, includeAdult: Boolean): Flow<PagingData<SearchResult>> =
        searchRepository.doMultiSearch(query, includeAdult)
}