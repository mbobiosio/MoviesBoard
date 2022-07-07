package com.cerminnovations.core.util

import com.cerminnovations.core.error.ErrorMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: ErrorMessage? = null) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

fun <T> Flow<T>.asResult(): Flow<Resource<T>> {
    return this
        .map<T, Resource<T>> {
            Resource.Success(it)
        }
        .onStart {
            emit(Resource.Loading)
        }
        .catch {
            emit(
                Resource.Error(
                    ErrorMessage("$it")
                )
            )
        }
}
