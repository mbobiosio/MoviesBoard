package com.cerminnovations.moviesboard.service.paging.artist

import androidx.paging.PagingSource
import com.cerminnovations.moviesboard.model.artists.Artist
import com.cerminnovations.moviesboard.service.ArtistType

class ArtistsDataSource(
    private val apiService: com.cerminnovations.moviesboard.api.APIService,
    private val artistType: ArtistType
) : PagingSource<Int, Artist>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artist> {
        return try {
            val nextPage = params.key ?: 1
            val response = loadPage(nextPage)

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    private suspend fun loadPage(
        page: Int?
    ): List<Artist> {
        val response = when (artistType) {
            ArtistType.POPULAR -> apiService.getPopularArtists(com.cerminnovations.moviesboard.BuildConfig.API_KEY, page)
            ArtistType.TRENDING_TODAY -> apiService.getTrendingArtists("person", "day", com.cerminnovations.moviesboard.BuildConfig.API_KEY, page)
            ArtistType.TRENDING_THIS_WEEK -> apiService.getTrendingArtists("person", "week", com.cerminnovations.moviesboard.BuildConfig.API_KEY, page)
        }
        return response.results
    }
}