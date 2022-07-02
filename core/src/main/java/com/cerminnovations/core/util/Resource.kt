package com.cerminnovations.core.util

import com.cerminnovations.core.error.ErrorMessage

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: ErrorMessage? = null) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}
