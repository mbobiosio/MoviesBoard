package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.moviesboard.data.remote.repository.PopularMovieRepoImpl
import com.cerminnovations.moviesboard.domain.repository.PopularMovieRepo
import com.cerminnovations.moviesboard.domain.usecase.PopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideMoviesUseCase(
        popularMovieRepo: PopularMovieRepo
    ): PopularMoviesUseCase = PopularMoviesUseCase(popularMovieRepo)

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideMovieRepository(
        movieRepositoryImpl: PopularMovieRepoImpl
    ): PopularMovieRepo = movieRepositoryImpl
}
