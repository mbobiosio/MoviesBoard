package com.mbobiosio.moviesboard.api

import com.mbobiosio.moviesboard.model.artists.Artist
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.model.movies.MovieDetails
import com.mbobiosio.moviesboard.model.response.APIResponse
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.shows.Series
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    /*Genres*/
    @GET("genre/movie/list")
    suspend fun movieGenres(
        @Query("language") language: String?
    ): APIResponse

    @GET("genre/tv/list")
    suspend fun showsGenres(
        @Query("language") language: String?
    ): APIResponse

    /*Movies*/
    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String?,
        @Query("append_to_response") appendToResponse: String?,
        @Query("include_image_language") imageLanguages: String?
    ): MovieDetails

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>


    /*Trending*/
    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("page") page: Int?,
        @Query("language") language: String?
    ): BaseResponse<Movie>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingSeries(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("page") page: Int?,
        @Query("language") language: String?
    ): BaseResponse<Series>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingPeoples(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("page") page: Int?,
        @Query("language") language: String?
    ): BaseResponse<Artist>

}