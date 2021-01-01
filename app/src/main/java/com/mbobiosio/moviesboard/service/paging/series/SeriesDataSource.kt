package com.mbobiosio.moviesboard.service.paging.series

import androidx.paging.PagingSource
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.api.APIService
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.service.SeriesType

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
            SeriesType.POPULAR -> apiService.getPopularSeries(BuildConfig.API_KEY, page)
            SeriesType.TOP_RATED -> apiService.getTopRatedSeries(BuildConfig.API_KEY, page)
            SeriesType.NOW_SHOWING -> apiService.getSeriesNowShowing(BuildConfig.API_KEY, page)
            SeriesType.SHOWING_TODAY -> apiService.getSeriesShowingToday(BuildConfig.API_KEY, page)
            SeriesType.TRENDING_TODAY -> apiService.getTrendingSeries(
                "tv",
                "day",
                BuildConfig.API_KEY,
                page
            )
            SeriesType.TRENDING_THIS_WEEK -> apiService.getTrendingSeries(
                "tv",
                "week",
                BuildConfig.API_KEY,
                page
            )
        }
        return response.results
    }
}