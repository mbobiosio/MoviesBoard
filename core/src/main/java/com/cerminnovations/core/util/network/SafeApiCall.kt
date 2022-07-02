package com.cerminnovations.core.util.network

import com.cerminnovations.core.error.ErrorMessage
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
                ErrorMessage("The connection request timed out. Please check your internet signal strength")
            )
            is NoInternetException -> Resource.Error(
                ErrorMessage("No internet connection")
            )
            is IOException -> Resource.Error(
                ErrorMessage("Connection detected without internet access")
            )
            is HttpException -> {
                val message = throwableResponse(throwable)
                return Resource.Error(message)
            }
            else -> Resource.Error(ErrorMessage("An unexpected error occurred"))
        }
    }
}

private fun throwableResponse(e: HttpException): ErrorMessage? =
    try {
        e.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
                .adapter(ErrorMessage::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (t: Throwable) {
        null
    }
