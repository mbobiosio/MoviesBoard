package com.mbobiosio.moviesboard.api

import com.mbobiosio.moviesboard.model.artists.Artist
import com.mbobiosio.moviesboard.model.artists.ArtistInfo
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.model.movies.MovieDetails
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.search.SearchResult
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.model.shows.SeriesDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    /*Movies*/
    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("append_to_response") appendToResponse: String?
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
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    /*Trending*/
    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Movie>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingSeries(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingArtists(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Artist>

    /*TV Series*/
    @GET("tv/{tv_id}")
    suspend fun getSeriesByID(
        @Path("tv_id") tvId: Int?,
        @Query("api_key") apiKey: String?,
        @Query("append_to_response") appendToResponse: String?
    ): SeriesDetails

    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET("tv/airing_today")
    suspend fun getSeriesShowingToday(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET("tv/on_the_air")
    suspend fun getSeriesNowShowing(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET("tv/top_rated")
    suspend fun getTopRatedSeries(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    /*Artists*/
    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Artist>

    @GET("person/{person_id}")
    suspend fun getArtistById(
        @Path("person_id") personId: Int?,
        @Query("api_key") apiKey: String?,
        @Query("append_to_response") appendToResponse: String?
    ): ArtistInfo

    /*Search*/
    @GET("search/multi")
    suspend fun search(
        @Query("api_key") apiKey: String?,
        @Query("query") query: String?,
        @Query("page") page: Int?,
        @Query("include_adult") isAdult: Boolean
    ): BaseResponse<SearchResult>
}