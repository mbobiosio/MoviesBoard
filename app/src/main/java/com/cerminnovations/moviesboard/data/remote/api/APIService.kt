package com.cerminnovations.moviesboard.data.remote.api

import com.cerminnovations.moviesboard.data.remote.model.artists.Artist
import com.cerminnovations.moviesboard.data.remote.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingArtists(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int?
    ): BaseResponse<Artist>

    /*TV Series*/

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
