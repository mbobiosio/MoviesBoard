package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.moviesboard.data.remote.model.response.Result
import com.cerminnovations.moviesboard.data.remote.model.shows.SeriesDetails
import com.cerminnovations.moviesboard.repositories.SeriesRepository
import kotlinx.coroutines.launch

class SeriesDetailViewModel : ViewModel() {
    private val seriesRepository = SeriesRepository()

    fun getSeriesDetails(seriesID: Int): LiveData<SeriesDetails> {
        val seriesDetails = MutableLiveData<SeriesDetails>()

        viewModelScope.launch {
            when (val result = getSeriesData(seriesID)) {
                is Result.Success -> seriesDetails.postValue(result.value)
            }
        }
        return seriesDetails
    }

    private suspend fun getSeriesData(id: Int) = seriesRepository.getSeriesByID(
        id,
        com.cerminnovations.moviesboard.BuildConfig.API_KEY,
        "images,credits,videos"
    )
}
