package com.cerminnovations.moviesboard.service.paging.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.core.constant.Constants.apiKey
import com.cerminnovations.moviesboard.data.remote.api.APIService
import com.cerminnovations.moviesboard.model.search.SearchResult
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class SearchDataSource(
    private val apiService: APIService,
    private var query: String,
    private var includeAdult: Boolean,
) : PagingSource<Int, SearchResult>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResult> {
        return try {
            val nextPage = params.key ?: 1
            val response = loadPage(page = nextPage, includeAdult)

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (t: Throwable) {
            Timber.e(t.localizedMessage)
            LoadResult.Error(t)
        }
    }

    private suspend fun loadPage(
        page: Int,
        adult: Boolean,
    ): List<SearchResult> {
        Timber.d("$page")
        val responseData = apiService.search(
            apiKey = apiKey,
            query,
            page,
            adult
        )
        return responseData.results
    }

    override fun getRefreshKey(state: PagingState<Int, SearchResult>): Int? {
        TODO("Not yet implemented")
    }
}
