package com.cerminnovations.core.base

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface BaseContract {
    fun observeData()
    fun showProgress(isVisible: Boolean)
    fun showError(isError: Boolean, error: String? = null)
}
