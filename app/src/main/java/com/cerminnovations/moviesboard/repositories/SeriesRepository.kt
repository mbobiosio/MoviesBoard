package com.cerminnovations.moviesboard.repositories

import com.cerminnovations.moviesboard.data.remote.api.RetrofitClient
import com.cerminnovations.moviesboard.model.response.BaseResponse
import com.cerminnovations.moviesboard.model.response.Result
import com.cerminnovations.moviesboard.model.shows.Series
import com.cerminnovations.moviesboard.model.shows.SeriesDetails

class SeriesRepository : BaseRepository() {

    private val apiService = RetrofitClient.apiService

    suspend fun getSeriesByID(id: Int?, apiKey: String?, response: String?): Result<SeriesDetails> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesByID(id, apiKey, response)
        }
    }

    suspend fun getPopularSeries(apiKey: String?, page: Int?): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getPopularSeries(apiKey, page)
        }
    }

    suspend fun getTopRatedSeries(apiKey: String?, page: Int?): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getTopRatedSeries(apiKey, page)
        }
    }

    suspend fun getSeriesShowingToday(apiKey: String?, page: Int?): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesShowingToday(apiKey, page)
        }
    }

    suspend fun getSeriesNowShowing(apiKey: String?, page: Int?): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesNowShowing(apiKey, page)
        }
    }
}
