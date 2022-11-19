package com.cerminnovations.moviesboard.data.remote.repository.favorite

import androidx.lifecycle.LiveData
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.Favorite
import com.cerminnovations.domain.repository.favorite.MovieFavoriteRepository
import com.cerminnovations.moviesboard.data.mappers.FavoriteMovieMapper
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class MovieFavoriteRepoImpl @Inject constructor(
    appDatabase: AppDatabase,
    private val mapper: FavoriteMovieMapper,
) : MovieFavoriteRepository {

    private val favoriteDao = appDatabase.movieFavorite

    override suspend fun insertFavorite(favorite: Favorite) {
        favoriteDao.insertData(favorite = favorite.mapEntityToDomain())
    }

    override suspend fun getAllFavorites(): LiveData<List<Favorite>> {
        TODO("Not yet implemented")
    }

    /*override suspend fun getAllFavorites(): List<Favorite> {
        return mapper.map(favoriteDao.getFavoriteMovies())
    }*/

    override suspend fun deleteItem(favorite: Favorite) {
        favoriteDao.deleteItem(favorite = favorite.mapEntityToDomain())
    }

    override suspend fun deleteAll() {
        favoriteDao.deleteAll()
    }
}