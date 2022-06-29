package com.cerminnovations.moviesboard.presentation.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.util.Resource
import com.cerminnovations.domain.usecase.UseCases
import com.cerminnovations.moviesboard.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _uIState: MutableLiveData<UIState> = MutableLiveData()
    val uiState: LiveData<UIState> get() = _uIState

    fun getMovieDetail(
        movieId: Long,
        language: String?,
        appendToResponse: String?
    ) {
        _uIState.value = UIState.Loading
        useCases.getMovieDetailUseCase.invoke(movieId, Constants.apiKey, language, appendToResponse).onEach { result ->
            _uIState.value = when (result) {
                is Resource.Loading -> UIState.Loading
                is Resource.Error -> UIState.Error(result.error)
                is Resource.Success -> UIState.Success(result.data)
            }
        }.launchIn(viewModelScope)
    }
}
