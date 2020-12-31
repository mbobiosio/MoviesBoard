package com.mbobiosio.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.model.movies.MovieDetails
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.repositories.MovieRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieDetailViewModel : ViewModel() {

    private val movieRepository = MovieRepository()

    fun getMovieDetails(id: Int): LiveData<MovieDetails> {


        val details = MutableLiveData<MovieDetails>()

        viewModelScope.launch {

            when (val result = fetchMovieData(id)) {
                is Result.Success -> details.postValue(result.value)

            }
        }

        return details

    }

    private suspend fun fetchMovieData(id: Int) = movieRepository.getMovieById(
        id, BuildConfig.API_KEY, null, "images,credits,videos", null

    )

}