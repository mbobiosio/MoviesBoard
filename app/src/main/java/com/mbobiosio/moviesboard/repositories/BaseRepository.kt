package com.mbobiosio.moviesboard.repositories

import com.mbobiosio.moviesboard.model.response.APIResponse
import com.mbobiosio.moviesboard.model.response.Result
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

open class BaseRepository {

    suspend fun <T> coroutineHandler(
        dispatcher: CoroutineDispatcher,
        apiRequest: suspend () -> T
    ) : Result<T> {
        return withContext(dispatcher) {
            try {
                Result.Success(apiRequest.invoke())
            } catch (e: IOException) {
                Result.NetworkError
            } catch (e: HttpException) {
                val errorCode = e.code()
                val errorMessage = throwableResponse(e)
                Timber.d("HttpException $errorCode : ${errorMessage?.errorCode} : ${errorMessage?.errorMessage}")
                Result.Error(errorCode, errorMessage)

            } catch (t: Throwable) {
                Timber.d(t)
                Result.Error(null, null)
            }
        }
    }

    open val dispatcher = Dispatchers.IO

    private fun throwableResponse(exception: HttpException): APIResponse? {
        return try {
            exception.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder()
                    .build()
                    .adapter(APIResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (t: Throwable) {
            Timber.d(t)
            null
        }
    }
}