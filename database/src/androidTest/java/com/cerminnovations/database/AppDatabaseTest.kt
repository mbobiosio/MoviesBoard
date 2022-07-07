package com.cerminnovations.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.cerminnovations.database.dao.movies.popular.PopularMoviesDao
import com.cerminnovations.database.entities.movies.popular.PopularMovie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class AppDatabaseTest {

    private lateinit var database: AppDatabase
    private lateinit var popularMoviesDao: PopularMoviesDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
        popularMoviesDao = database.popularMoviesDao
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testPopularEntity() = runTest {
        val popularEntities = listOf(
            testPopularMovieEntity(1242, "Simo", ""),
            testPopularMovieEntity(2963, "", "Original sin")
        )
    }

    private fun testPopularMovieEntity(
        id: Long = 0,
        title: String,
        originalTitle: String
    ) = PopularMovie(
        movieId = id,
        title = title,
        originalTitle = originalTitle,
        overview = "",
        posterPath = "",
        backdropPath = "",
        releaseDate = "",
        originalLanguage = "",
        popularity = 225.21,
        voteCount = 1,
        voteAverage = 1.4,
        isAdult = true
    )
}
