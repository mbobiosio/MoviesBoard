package com.cerminnovations.moviesboard.viewmodels

/*

class MoviesViewModel : ViewModel() {

    private val movieRepository = MovieRepository()
    private val trendingRepository = TrendingRepository()

    private val queryType = MutableLiveData(DEFAULT_MOVIES_TYPE)
*/
/*

    fun getMovies() = Transformations.switchMap(queryType) {

        val dataList = MutableLiveData<List<Movie>>()
        viewModelScope.launch {
            val result = when (it) {
                MovieType.TOP_RATED -> getTopRated()
                MovieType.UPCOMING -> getUpcomingMovies()
                MovieType.NOW_PLAYING -> getNowPlayingMovies()
                MovieType.TRENDING_TODAY -> getTrendingToday()
                MovieType.TRENDING_THIS_WEEK -> getTrendingWeek()
                else -> getPopularMovies()
            }
            when (result) {
                is Result.Success -> dataList.postValue(result.value.results)
                else -> Result.Error()
            }
        }
        dataList
    }
*//*


    private suspend fun getPopularMovies() = movieRepository.getPopularMovies(
        apiKey = apiKey,
        null,
        1,
        null
    )

    private suspend fun getTopRated() = movieRepository.getTopRatedMovies(
        apiKey = apiKey,
        null,
        1,
        null
    )

    private suspend fun getUpcomingMovies() = movieRepository.getUpcomingMovies(
        apiKey = apiKey,
        null,
        1,
        null
    )

    private suspend fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies(
        apiKey = apiKey,
        null,
        1,
        null
    )

    private suspend fun getTrendingToday() =
        trendingRepository.getTrendingMovies(TrendingRepository.TimeFrame.DAY, 1)

    private suspend fun getTrendingWeek() =
        trendingRepository.getTrendingMovies(TrendingRepository.TimeFrame.WEEK, 1)

    fun updateMovieType(query: MovieType) {
        queryType.postValue(query)
    }
}
*/
