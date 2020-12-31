package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.model.response.BaseResponse
import com.mbobiosio.moviesboard.model.response.Result
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.model.shows.SeriesDetails

class SeriesRepository : BaseRepository() {

    private val apiService = RetrofitClient.apiService

    suspend fun getSeriesByID(id: Int?, response: String?, images: String?
    ): Result<SeriesDetails> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesByID(id, response, images)
        }
    }

    suspend fun getPopularSeries(apiKey: String?, page: Int?
    ): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getPopularSeries(apiKey, page)
        }
    }

    suspend fun getTopRatedSeries(page: Int?
    ): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getTopRatedSeries(page)
        }
    }

    suspend fun getSeriesShowingToday(page: Int?
    ): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesShowingToday(page)
        }
    }

    suspend fun getSeriesNowShowing(page: Int?
    ): Result<BaseResponse<Series>> {
        return coroutineHandler(dispatcher) {
            apiService.getSeriesNowShowing(page)
        }
    }
}