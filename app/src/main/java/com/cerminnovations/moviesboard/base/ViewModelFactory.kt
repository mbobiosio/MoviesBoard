package com.cerminnovations.moviesboard.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val viewModel: ViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(viewModel::class.java) -> {
                return viewModel as T
            }
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}
