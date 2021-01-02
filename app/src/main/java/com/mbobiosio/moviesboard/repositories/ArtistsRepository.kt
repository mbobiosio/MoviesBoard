package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.model.artists.ArtistInfo
import com.mbobiosio.moviesboard.model.response.Result

class ArtistsRepository : BaseRepository() {
    private val apiService = RetrofitClient.apiService

    suspend fun getArtistByID(
        artistId: Int?,
        apKey: String?,
        responseData: String
    ): Result<ArtistInfo> {
        return coroutineHandler(dispatcher) {
            apiService.getArtistById(artistId, apKey, responseData)
        }
    }
}