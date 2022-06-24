package com.cerminnovations.moviesboard.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
abstract class BaseViewModel : ViewModel() {

    private val _loadingState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean> get() = _loadingState

    protected fun isLoading(isLoading: Boolean) = _loadingState.postValue(isLoading)
}
