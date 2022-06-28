package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.moviesboard.BuildConfig
import com.cerminnovations.moviesboard.model.movies.MovieDetails
import com.cerminnovations.moviesboard.model.response.Result
import com.cerminnovations.moviesboard.repositories.MovieRepository
import kotlinx.coroutines.launch

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
        id,
        BuildConfig.API_KEY,
        null,
        "images, reviews,credits,videos"
    )
}
