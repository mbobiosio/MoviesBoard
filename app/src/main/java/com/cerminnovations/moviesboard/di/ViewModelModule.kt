package com.cerminnovations.moviesboard.di

import com.cerminnovations.moviesboard.base.ViewModelFactory
import com.cerminnovations.moviesboard.domain.usecase.PopularMoviesUseCase
import com.cerminnovations.moviesboard.presentation.movies.popularmovies.PopularMoviesVM
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(FragmentComponent::class)
class ViewModelModule {

    @Provides
    @FragmentScoped
    fun providePopularViewModel(
        popularMoviesUseCase: PopularMoviesUseCase
    ): PopularMoviesVM {
        return ViewModelFactory(PopularMoviesVM(popularMoviesUseCase)).create(
            PopularMoviesVM::class.java
        )
    }
}
