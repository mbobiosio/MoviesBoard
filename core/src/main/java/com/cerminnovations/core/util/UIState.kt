package com.cerminnovations.core.util

import com.cerminnovations.core.error.ErrorMessage

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
sealed class UIState<out T> where T : Any? {
    object Loading : UIState<Nothing>()
    data class Error(val message: ErrorMessage? = null) : UIState<Nothing>()
    data class Success<T>(val result: T) : UIState<T>()
}
