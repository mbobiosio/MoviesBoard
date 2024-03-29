package com.cerminnovations.moviesboard.presentation.seriesdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.UIState
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class SeriesDetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _uiState: MutableLiveData<DataState> = MutableLiveData()
    val uiState: LiveData<DataState> get() = _uiState

    fun getTvDetails(tvId: Long?) {
        _uiState.value = UIState.Loading
        useCases.getSeriesDetailUseCase.invoke(
            tvId,
            Constants.apiKey,
            "images,reviews,credits,videos"
        )
            .onEach { result ->
                _uiState.value = when (result) {
                    is Resource.Loading -> UIState.Loading
                    is Resource.Success -> UIState.Success(result.data)
                    is Resource.Error -> UIState.Error(
                        result.error
                    )
                }
            }.launchIn(viewModelScope)
    }
}

typealias DataState = UIState<TvSeriesInfo>
