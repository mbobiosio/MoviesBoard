package com.cerminnovations.core.util.network

import com.cerminnovations.core.error.ErrorResponse
import com.cerminnovations.core.util.Resource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): Resource<T> {
    return try {
        Resource.Success(apiCall())
    } catch (throwable: Throwable) {
        when (throwable) {
            is SocketTimeoutException -> Resource.Error(
                ErrorResponse("The connection request timed out. Please check your internet signal strength")
            )
            is NoInternetException -> Resource.Error(
                ErrorResponse("No internet connection")
            )
            is IOException -> Resource.Error(
                ErrorResponse("Connection detected without internet access")
            )
            is HttpException -> {
                val message = throwableResponse(throwable)
                return Resource.Error(message)
            }
            else -> Resource.Error(ErrorResponse("An unexpected error occurred"))
        }
    }
}

private fun throwableResponse(e: HttpException): ErrorResponse? =
    try {
        e.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
                .adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (t: Throwable) {
        null
    }
