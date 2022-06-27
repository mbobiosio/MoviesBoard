package com.cerminnovations.moviesboard.service.paging.series

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.moviesboard.model.shows.Series
import com.cerminnovations.moviesboard.service.SeriesType

class SeriesDataSource(
    private val apiService: com.cerminnovations.moviesboard.api.APIService,
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
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
            SeriesType.TOP_RATED -> apiService.getTopRatedSeries(
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
            SeriesType.NOW_SHOWING -> apiService.getSeriesNowShowing(
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
            SeriesType.SHOWING_TODAY -> apiService.getSeriesShowingToday(
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
            SeriesType.TRENDING_TODAY -> apiService.getTrendingSeries(
                "tv",
                "day",
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
            SeriesType.TRENDING_THIS_WEEK -> apiService.getTrendingSeries(
                "tv",
                "week",
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
        }
        return response.results
    }

    override fun getRefreshKey(state: PagingState<Int, Series>) =
        state.anchorPosition
}
