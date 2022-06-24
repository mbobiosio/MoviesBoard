package com.cerminnovations.moviesboard.data.remote.api

import com.cerminnovations.moviesboard.data.remote.model.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse
}
