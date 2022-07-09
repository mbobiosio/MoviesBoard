package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.database.entities.tv.nowshowing.NowShowing
import com.cerminnovations.database.entities.tv.popular.PopularTv
import com.cerminnovations.database.entities.tv.showingtoday.ShowingToday
import com.cerminnovations.database.entities.tv.toprated.TopRatedTv
import com.cerminnovations.database.entities.tv.trendingtoday.TrendingToday
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeek
import com.cerminnovations.domain.model.response.ListResponse
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.tv.Series
import com.cerminnovations.moviesboard.data.remote.model.tv.SeriesDetails
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TvDetailMapper @Inject constructor() : Mapper<SeriesDetails, TvSeriesInfo> {
    override fun map(input: SeriesDetails): TvSeriesInfo = TvSeriesInfo(
        id = input.id,
        name = input.name,
        overview = input.overview,
        type = input.type,
        backdropPath = input.backdropPath,
        posterPath = input.posterPath,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        firstAirDate = input.firstAirDate,
        lastAirDate = input.lastAirDate,
        homepage = input.homepage,
        numberOfSeasons = input.numberOfSeasons,
        numberOfEpisodes = input.numberOfEpisodes,
        inProduction = input.inProduction,
        popularity = input.popularity,
        status = input.status,
        originalName = input.originalName,
        originalLanguage = input.originalLanguage,
        episodeRunTime = input.episodeRunTime,
        languages = input.languages,
        originCountry = input.originCountry
    )
}

fun BaseResponse<Series>.mapDataToEntity(): ListResponse<PopularTv> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                PopularTv(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun BaseResponse<Series>.mapTopRatedDataToEntity(): ListResponse<TopRatedTv> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                TopRatedTv(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun BaseResponse<Series>.mapNowShowingDataToEntity(): ListResponse<NowShowing> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                NowShowing(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun BaseResponse<Series>.mapShowingTodayDataToEntity(): ListResponse<ShowingToday> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                ShowingToday(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun BaseResponse<Series>.mapTrendingTodayDataToEntity(): ListResponse<TrendingToday> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                TrendingToday(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun BaseResponse<Series>.mapTrendingWeekDataToEntity(): ListResponse<TrendingWeek> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                TrendingWeek(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun PopularTv.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }

fun TopRatedTv.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }

fun NowShowing.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }

fun ShowingToday.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }

fun TrendingToday.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }

fun TrendingWeek.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }
