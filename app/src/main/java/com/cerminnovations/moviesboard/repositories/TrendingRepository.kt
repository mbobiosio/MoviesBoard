package com.cerminnovations.moviesboard.repositories

import com.cerminnovations.moviesboard.data.remote.api.RetrofitClient
import com.cerminnovations.moviesboard.model.movies.Movie
import com.cerminnovations.moviesboard.model.response.BaseResponse
import com.cerminnovations.moviesboard.model.response.Result
import com.cerminnovations.moviesboard.model.shows.Series

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
            apiService.getTrendingMovies(
                MediaType.MOVIE.path,
                time.path,
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
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
                com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                page
            )
        }
    }
}
