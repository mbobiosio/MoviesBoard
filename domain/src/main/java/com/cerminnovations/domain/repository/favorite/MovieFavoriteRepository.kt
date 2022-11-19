package com.cerminnovations.domain.repository.favorite

import androidx.lifecycle.LiveData
import com.cerminnovations.domain.model.Favorite

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface MovieFavoriteRepository {

    suspend fun insertFavorite(favorite: Favorite)

    suspend fun getAllFavorites(): LiveData<List<Favorite>>

    suspend fun deleteItem(favorite: Favorite)

    suspend fun deleteAll()
}