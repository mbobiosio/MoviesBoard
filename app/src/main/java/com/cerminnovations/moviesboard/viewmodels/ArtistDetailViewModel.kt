package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.moviesboard.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.model.response.Result
import com.cerminnovations.moviesboard.repositories.ArtistsRepository
import kotlinx.coroutines.launch

class ArtistDetailViewModel : ViewModel() {
    private val artistRepository = ArtistsRepository()

    private val artistInfo = MutableLiveData<ArtistInfo>()
    val artist: LiveData<ArtistInfo> get() = artistInfo

    fun artistProfile(artistId: Int) {
        viewModelScope.launch {
            when (val result = getArtistData(artistId)) {
                is Result.Success -> artistInfo.postValue(result.value)
            }
        }
    }

    private suspend fun getArtistData(artistId: Int): Result<ArtistInfo> {
        return artistRepository.getArtistByID(
            artistId,
            com.cerminnovations.moviesboard.BuildConfig.API_KEY,
            "movie_credits,tv_credits,images,tagged_images"
        )
    }
}
