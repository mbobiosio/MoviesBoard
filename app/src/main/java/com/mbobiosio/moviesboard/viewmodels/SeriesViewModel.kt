package com.mbobiosio.moviesboard.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.repositories.SeriesRepository
import com.mbobiosio.moviesboard.repositories.TrendingRepository
import com.mbobiosio.moviesboard.service.SeriesType
import com.mbobiosio.moviesboard.util.DEFAULT_SERIES_TYPE
import kotlinx.coroutines.launch

class SeriesViewModel : ViewModel() {
    private val trendingRepository = TrendingRepository()
    private val seriesRepository = SeriesRepository()

    private val seriesType = MutableLiveData(DEFAULT_SERIES_TYPE)

    fun getAllSeries() = Transformations.switchMap(seriesType) {
        val dataList = MutableLiveData<List<Series>>()
        viewModelScope.launch {
            val result = when (it) {
                SeriesType.TOP_RATED -> getTopRatedSeries()
                SeriesType.SHOWING_TODAY -> getSeriesShowingToday()
                SeriesType.NOW_SHOWING -> getSeriesNowShowing()
                SeriesType.TRENDING_TODAY -> getTodayTrendingSeries()
                SeriesType.TRENDING_THIS_WEEK -> getWeekTrendingSeries()
                else -> getPopularSeries()
            }
            when (result) {
                is Result.Success -> dataList.postValue(result.value.results)
            }
        }
        dataList
    }

    private suspend fun getTopRatedSeries() = seriesRepository.getTopRatedSeries(BuildConfig.API_KEY, 1)

    private suspend fun getSeriesShowingToday() = seriesRepository.getSeriesShowingToday(BuildConfig.API_KEY, 1)

    private suspend fun getSeriesNowShowing() = seriesRepository.getSeriesNowShowing(BuildConfig.API_KEY, 1)

    private suspend fun getPopularSeries() = seriesRepository.getPopularSeries(BuildConfig.API_KEY, 1)

    private suspend fun getTodayTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.DAY, 1)

    private suspend fun getWeekTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.WEEK, 1)

    fun updateSeriesType(type: SeriesType) {
        seriesType.postValue(type)
    }
}