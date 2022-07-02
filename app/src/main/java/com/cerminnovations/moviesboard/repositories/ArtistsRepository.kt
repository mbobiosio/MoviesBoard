package com.cerminnovations.moviesboard.repositories

import com.cerminnovations.moviesboard.data.remote.api.RetrofitClient
import com.cerminnovations.moviesboard.data.remote.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.data.remote.model.response.Result

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
