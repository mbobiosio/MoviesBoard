package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.moviesboard.data.remote.repository.movies.PopularMovieRepoImpl
import com.cerminnovations.moviesboard.data.remote.repository.movies.TopRatedMoviesRepoImpl
import com.cerminnovations.moviesboard.domain.repository.movies.PopularMovieRepo
import com.cerminnovations.moviesboard.domain.repository.movies.TopRatedMoviesRepo
import com.cerminnovations.moviesboard.domain.usecase.movies.PopularMoviesUseCase
import com.cerminnovations.moviesboard.domain.usecase.movies.TopRatedUseCase
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
    fun provideTopRatedUseCase(
        topRatedMoviesRepo: TopRatedMoviesRepo
    ): TopRatedUseCase = TopRatedUseCase(topRatedMoviesRepo)

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideMovieRepository(
        movieRepositoryImpl: PopularMovieRepoImpl
    ): PopularMovieRepo = movieRepositoryImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideTopRatedRepository(
        topRatedMoviesRepoImpl: TopRatedMoviesRepoImpl
    ): TopRatedMoviesRepo = topRatedMoviesRepoImpl
}
