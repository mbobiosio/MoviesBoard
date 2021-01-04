package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.model.movies.MovieDetails
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.response.Result

class MovieRepository : BaseRepository() {

    private val apiService = RetrofitClient.apiService

    suspend fun getPopularMovies(
        apiKey: String?,
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getPopularMovies(
                apiKey,
                language,
                page,
                region
            )
        }
    }

    suspend fun getTopRatedMovies(
        apiKey: String?,
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getTopRatedMovies(
                apiKey,
                language,
                page,
                region
            )
        }
    }

    suspend fun getUpcomingMovies(
        apiKey: String?,
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getUpcomingMovies(
                apiKey,
                language,
                page,
                region
            )
        }
    }

    suspend fun getNowPlayingMovies(
        apiKey: String?,
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getNowPlayingMovies(
                apiKey,
                language,
                page,
                region
            )
        }
    }

    suspend fun getMovieById(
        movieId: Int,
        apiKey: String?,
        language: String?,
        appendToResponse: String?
    ): Result<MovieDetails> {
        return coroutineHandler(dispatcher) {
            apiService.getMovieById(
                movieId, apiKey, language, appendToResponse
            )
        }
    }
}