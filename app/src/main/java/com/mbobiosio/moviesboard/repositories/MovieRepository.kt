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
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getTopRatedMovies(
                language,
                page,
                region
            )
        }
    }

    suspend fun getUpcomingMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getUpcomingMovies(
                language,
                page,
                region
            )
        }
    }

    suspend fun getNowPlayingMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Result<BaseResponse<Movie>> {
        return coroutineHandler(dispatcher) {
            apiService.getNowPlayingMovies(
                language,
                page,
                region
            )
        }
    }

    suspend fun getMovieById(
        movieId: Int,
        language: String?,
        appendToResponse: String?,
        imageLanguages: String?
    ): Result<MovieDetails> {
        return coroutineHandler(dispatcher) {
            apiService.getMovieById(
                movieId,
                language,
                appendToResponse,
                imageLanguages
            )
        }
    }

}