package com.cerminnovations.moviesboard.di

import android.content.Context
import androidx.room.Room
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.local.dao.PopularMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "tmdb_db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMoviesDao(appDatabase: AppDatabase): PopularMoviesDao = appDatabase.popularMoviesDao
}
