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
                SeriesType.AIRING_TODAY -> getSeriesShowingToday()
                SeriesType.ON_THE_AIR -> getSeriesNowShowing()
                SeriesType.TRENDING_DAILY -> getTodayTrendingSeries()
                SeriesType.TRENDING_WEEKLY -> getWeekTrendingSeries()
                else -> getPopularSeries()
            }
            when (result) {
                is Result.Success -> dataList.postValue(result.value.results)
            }
        }
        dataList
    }

    private suspend fun getTopRatedSeries() = seriesRepository.getTopRatedSeries(1)

    private suspend fun getSeriesShowingToday() = seriesRepository.getSeriesShowingToday(1)

    private suspend fun getSeriesNowShowing() = seriesRepository.getSeriesNowShowing(1)

    private suspend fun getPopularSeries() = seriesRepository.getPopularSeries(BuildConfig.API_KEY, 1)

    private suspend fun getTodayTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.DAY, 1, null)

    private suspend fun getWeekTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.WEEK, 1, null)

    fun updateSeriesType(type: SeriesType) {
        seriesType.postValue(type)
    }
}