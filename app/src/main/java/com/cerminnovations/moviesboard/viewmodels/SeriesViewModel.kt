package com.cerminnovations.moviesboard.viewmodels

/*

class SeriesViewModel : ViewModel() {
    private val trendingRepository = TrendingRepository()
    private val seriesRepository = SeriesRepository()

    private val seriesType = MutableLiveData(DEFAULT_SERIES_TYPE)
*/
/*

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
                else -> Result.Error()
            }
        }
        dataList
    }
*//*


    private suspend fun getTopRatedSeries() =
        seriesRepository.getTopRatedSeries(com.cerminnovations.moviesboard.BuildConfig.API_KEY, 1)

    private suspend fun getSeriesShowingToday() = seriesRepository.getSeriesShowingToday(
        com.cerminnovations.moviesboard.BuildConfig.API_KEY,
        1
    )

    private suspend fun getSeriesNowShowing() =
        seriesRepository.getSeriesNowShowing(com.cerminnovations.moviesboard.BuildConfig.API_KEY, 1)

    private suspend fun getPopularSeries() =
        seriesRepository.getPopularSeries(com.cerminnovations.moviesboard.BuildConfig.API_KEY, 1)

    private suspend fun getTodayTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.DAY, 1)

    private suspend fun getWeekTrendingSeries() =
        trendingRepository.getTrendingSeries(TrendingRepository.TimeFrame.WEEK, 1)

    fun updateSeriesType(type: SeriesType) {
        seriesType.postValue(type)
    }
}
*/
