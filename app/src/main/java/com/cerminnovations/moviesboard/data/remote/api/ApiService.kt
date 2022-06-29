package com.cerminnovations.moviesboard.data.remote.api

import com.cerminnovations.moviesboard.data.remote.model.movie.MovieResponse
import com.cerminnovations.moviesboard.model.movies.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface ApiService {

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("append_to_response") appendToResponse: String?
    ): MovieDetails

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

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): MovieResponse

    /*Trending*/
    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): MovieResponse
}
