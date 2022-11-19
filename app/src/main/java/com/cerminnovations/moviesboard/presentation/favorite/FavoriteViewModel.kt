package com.cerminnovations.moviesboard.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cerminnovations.domain.model.Favorite
import com.cerminnovations.domain.repository.favorite.MovieFavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRepository: MovieFavoriteRepository,
): ViewModel() {

    suspend fun getAll(): LiveData<List<Favorite>> = favoriteRepository.getAllFavorites()
}