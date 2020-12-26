package com.mbobiosio.moviesboard.api

import com.mbobiosio.moviesboard.model.response.APIResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("genre/movie/list")
    suspend fun movieGenres(
        @Query("language") language: String?
    ): APIResponse

    @GET("genre/tv/list")
    suspend fun showsGenres(
        @Query("language") language: String?
    ): APIResponse

}