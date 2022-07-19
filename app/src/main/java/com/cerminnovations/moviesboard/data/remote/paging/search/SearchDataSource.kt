package com.cerminnovations.moviesboard.data.remote.paging.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.core.constant.Constants.apiKey
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResultDto
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class SearchDataSource @Inject constructor(
    private val apiService: ApiService,
    private var query: String,
    private var includeAdult: Boolean
) : PagingSource<Int, SearchResultDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResultDto> {
        return try {
            val position = params.key ?: 1
            val response = apiService.search(
                apiKey = apiKey,
                query = query,
                page = position,
                isAdult = includeAdult
            )

            LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.results.isEmpty()) null else position + 1
            )
        } catch (t: Throwable) {
            Timber.e(t.localizedMessage)
            LoadResult.Error(t)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SearchResultDto>): Int? {
        return state.anchorPosition?.let { pos ->
            val anchorPage = state.closestPageToPosition(pos)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
