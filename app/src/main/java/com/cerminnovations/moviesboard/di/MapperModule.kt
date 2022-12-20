package com.cerminnovations.moviesboard.di

import com.cerminnovations.moviesboard.data.mappers.FavoriteMovieMapper
import com.cerminnovations.moviesboard.data.mappers.MovieDetailMapper
import com.cerminnovations.moviesboard.data.mappers.PeopleMapper
import com.cerminnovations.moviesboard.data.mappers.TvDetailMapper
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
object MapperModule {

    @Provides
    @Singleton
    fun provideMovieDetailDTOMapper() = MovieDetailMapper()

    @Provides
    @Singleton
    fun provideTvDetailDtoMapper() = TvDetailMapper()

    @Provides
    @Singleton
    fun providePeopleMapper() = PeopleMapper()

    @Provides
    @Singleton
    fun provideMovieFavoriteMapper() = FavoriteMovieMapper()
}