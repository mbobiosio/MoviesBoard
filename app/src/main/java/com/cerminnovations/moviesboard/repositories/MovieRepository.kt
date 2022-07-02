package com.cerminnovations.moviesboard.repositories

import com.cerminnovations.moviesboard.data.remote.api.RetrofitClient
import com.cerminnovations.moviesboard.data.remote.model.movie.Movie
import com.cerminnovations.moviesboard.data.remote.model.movie.MovieDetails
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.response.Result

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
