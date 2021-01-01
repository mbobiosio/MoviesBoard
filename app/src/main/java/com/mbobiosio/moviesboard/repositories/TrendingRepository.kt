package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.model.shows.Series

class TrendingRepository : BaseRepository() {

    private val apiService = RetrofitClient.apiService

    private enum class MediaType(val path: String) {
        ALL("all"),
        MOVIE("movie"),
        SERIES("tv"),
        ARTIST("person")
    }

    enum class TimeFrame(val path: String) {
        DAY("day"),
        WEEK("week")
    }

    suspend fun getTrendingMovies(
        time: TimeFrame,
        page: Int?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getTrendingMovies(MediaType.MOVIE.path, time.path, BuildConfig.API_KEY, page)
        }
    }

    suspend fun getTrendingSeries(
        time: TimeFrame,
        page: Int?
    ): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getTrendingSeries(
                MediaType.SERIES.path,
                time.path,
                BuildConfig.API_KEY,
                page
            )
        }
    }
}