package com.mbobiosio.moviesboard.service.paging.search

import androidx.paging.PagingSource
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.api.APIService
import com.mbobiosio.moviesboard.model.search.SearchResult
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
        val responseData = apiService.search(BuildConfig.API_KEY, query, page, adult)
        return responseData.results
    }
}