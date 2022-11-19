package com.cerminnovations.moviesboard.presentation.peopledetail

import androidx.lifecycle.*
import com.cerminnovations.core.base.BaseViewModel
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.UIState
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArtistDetailViewModel @Inject constructor(
    private val useCases: UseCases
) : BaseViewModel() {

    private val _uiState: MutableLiveData<DataState> = MutableLiveData()
    val uiState: LiveData<UIState<PersonInfo>> get() = _uiState

    fun getPersonInfo(
        personId: Long
    ) {
        _uiState.value = UIState.Loading
        useCases.getPeopleInfoUseCase.invoke(
            personId,
            Constants.apiKey,
            "movie_credits,tv_credits,images,tagged_images"
        )
            .onEach { result ->
                _uiState.value = when (result) {
                    is Resource.Loading -> UIState.Loading
                    is Resource.Error -> UIState.Error(
                        result.error
                    )
                    is Resource.Success -> UIState.Success(result.data)
                }
            }.launchIn(viewModelScope)
    }
}

typealias DataState = UIState<PersonInfo>
