package com.cerminnovations.moviesboard.presentation.seriesdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.util.Resource
import com.cerminnovations.domain.uistate.tv.TvUiState
import com.cerminnovations.domain.usecase.UseCases
import com.cerminnovations.moviesboard.data.mappers.mapDataToDomain
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

    private val _uiState: MutableLiveData<TvUiState> = MutableLiveData()
    val uiState: LiveData<TvUiState> get() = _uiState

    fun getTvDetails(tvId: Long?) {
        _uiState.value = TvUiState.Loading
        useCases.getSeriesDetailUseCase.invoke(
            tvId,
            Constants.apiKey,
            "images,reviews,credits,videos"
        )
            .onEach { result ->
                _uiState.value = when (result) {
                    is Resource.Loading -> TvUiState.Loading
                    is Resource.Success -> TvUiState.Success(result.data)
                    is Resource.Error -> TvUiState.Error(
                        result.error?.mapDataToDomain()
                    )
                }
            }.launchIn(viewModelScope)
    }
}
