package com.mbobiosio.moviesboard.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.repositories.MovieRepository
import com.mbobiosio.moviesboard.repositories.TrendingRepository
import com.mbobiosio.moviesboard.service.MovieType
import com.mbobiosio.moviesboard.util.DEFAULT_MOVIES_TYPE
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    private val movieRepository = MovieRepository()
    private val trendingRepository = TrendingRepository()

    private val queryType = MutableLiveData(DEFAULT_MOVIES_TYPE)

    fun getMovies() = Transformations.switchMap(queryType) {

        val dataList = MutableLiveData<List<Movie>>()
        viewModelScope.launch {
            val result = when(it) {
                MovieType.TOP_RATED -> getTopRated()
                MovieType.UPCOMING -> getUpcomingMovies()
                MovieType.NOW_PLAYING -> getNowPlayingMovies()
                MovieType.TRENDING_DAILY -> getTrendingToday()
                MovieType.TRENDING_WEEKLY -> getTrendingWeek()
                else -> getPopularMovies()
            }
            when(result) {
                is Result.Success -> dataList.postValue(result.value.results)
                else -> Result.Error()
            }
        }
        dataList
    }

    private suspend fun getPopularMovies() = movieRepository.getPopularMovies(BuildConfig.API_KEY,null, 1, null)

    private suspend fun getTopRated() = movieRepository.getTopRatedMovies(BuildConfig.API_KEY,null, 1, null)

    private suspend fun getUpcomingMovies() = movieRepository.getUpcomingMovies(BuildConfig.API_KEY,null, 1, null)

    private suspend fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies(BuildConfig.API_KEY,null, 1, null)

    private suspend fun getTrendingToday() = trendingRepository.getTrendingMovies(TrendingRepository.TimeFrame.DAY, 1, null)

    private suspend fun getTrendingWeek() = trendingRepository.getTrendingMovies(TrendingRepository.TimeFrame.WEEK, 1, null)

    fun updateMovieType(query: MovieType) {
        queryType.postValue(query)
    }
}