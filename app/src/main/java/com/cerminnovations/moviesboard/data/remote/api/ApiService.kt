package com.cerminnovations.moviesboard.data.remote.api

import com.cerminnovations.moviesboard.data.remote.model.artists.Artist
import com.cerminnovations.moviesboard.data.remote.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.data.remote.model.movie.Movie
import com.cerminnovations.moviesboard.data.remote.model.movie.MovieDetails
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResult
import com.cerminnovations.moviesboard.data.remote.model.tv.Series
import com.cerminnovations.moviesboard.data.remote.model.tv.SeriesDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface ApiService {

    /*
    * Movies
    * */
    @GET(value = "movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("append_to_response") appendToResponse: String?
    ): MovieDetails

    @GET(value = "movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET(value = "movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET(value = "movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET(value = "movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ): BaseResponse<Movie>

    @GET(value = "trending/{media_type}/{time_window}")
    suspend fun getTrendingMovies(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Movie>
    // End Movies

    /*
    * Series
    * */
    @GET(value = "tv/{tv_id}")
    suspend fun getSeriesByID(
        @Path("tv_id") tvId: Long?,
        @Query("api_key") apiKey: String?,
        @Query("append_to_response") appendToResponse: String?
    ): SeriesDetails

    @GET(value = "tv/popular")
    suspend fun getPopularSeries(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET(value = "tv/top_rated")
    suspend fun getTopRatedSeries(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET(value = "tv/airing_today")
    suspend fun getSeriesShowingToday(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET(value = "tv/on_the_air")
    suspend fun getSeriesNowShowing(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingSeries(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Series>
    // End series

    /*
    * Artists
    * */
    @GET(value = "person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Artist>

    @GET(value = "person/{person_id}")
    suspend fun getArtistById(
        @Path("person_id") personId: Long?,
        @Query("api_key") apiKey: String?,
        @Query("append_to_response") appendToResponse: String?
    ): ArtistInfo

    /*Search*/
    @GET(value = "search/multi")
    suspend fun search(
        @Query("api_key") apiKey: String?,
        @Query("query") query: String?,
        @Query("page") page: Int?,
        @Query("include_adult") isAdult: Boolean
    ): BaseResponse<SearchResult>
}
