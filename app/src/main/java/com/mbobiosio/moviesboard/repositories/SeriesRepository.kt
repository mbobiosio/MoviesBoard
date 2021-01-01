package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.model.shows.SeriesDetails

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