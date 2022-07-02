package com.cerminnovations.moviesboard.service.paging.series

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.core.constant.Constants.apiKey
import com.cerminnovations.moviesboard.data.remote.api.APIService
import com.cerminnovations.moviesboard.data.remote.model.shows.Series
import com.cerminnovations.moviesboard.service.SeriesType

class SeriesDataSource(
    private val apiService: APIService,
    private val seriesType: SeriesType
) : PagingSource<Int, Series>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Series> {
        return try {

            val newPage = params.key ?: 1
            val response = loadPage(page = newPage)

            LoadResult.Page(
                data = response,
                prevKey = if (newPage == 1) null else newPage - 1,
                nextKey = newPage + 1
            )
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    private suspend fun loadPage(
        page: Int
    ): List<Series> {
        val response = when (seriesType) {
            SeriesType.POPULAR -> apiService.getPopularSeries(
                apiKey = apiKey,
                page
            )
            SeriesType.TOP_RATED -> apiService.getTopRatedSeries(
                apiKey = apiKey,
                page
            )
            SeriesType.NOW_SHOWING -> apiService.getSeriesNowShowing(
                apiKey = apiKey,
                page
            )
            SeriesType.SHOWING_TODAY -> apiService.getSeriesShowingToday(
                apiKey = apiKey,
                page
            )
            SeriesType.TRENDING_TODAY -> apiService.getTrendingSeries(
                "tv",
                "day",
                apiKey = apiKey,
                page
            )
            SeriesType.TRENDING_THIS_WEEK -> apiService.getTrendingSeries(
                "tv",
                "week",
                apiKey = apiKey,
                page
            )
        }
        return response.results
    }

    override fun getRefreshKey(state: PagingState<Int, Series>): Int? {
        TODO("Not yet implemented")
    }
}
