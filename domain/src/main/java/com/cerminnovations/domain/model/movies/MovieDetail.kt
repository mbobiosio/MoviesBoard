package com.cerminnovations.domain.model.movies

import com.cerminnovations.domain.model.Collection
import com.cerminnovations.domain.model.Credit
import com.cerminnovations.domain.model.Genre
import com.cerminnovations.domain.model.SpokenLanguage
import com.cerminnovations.domain.model.graphics.Images
import com.cerminnovations.domain.model.production.ProductionCompany
import com.cerminnovations.domain.model.production.ProductionCountry
import com.cerminnovations.domain.model.video.VideoResponse

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class MovieDetail(
    val id: Long,
    val imdbId: String?,
    val title: String,
    val originalTitle: String,
    val originalLanguage: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String,
    val runtime: Int?,
    val voteCount: Int,
    val voteAverage: Double,
    val status: String,
    val tagline: String?,
    val budget: Int,
    val popularity: Double,
    val revenue: Long,
    val adult: Boolean,
    val homepage: String?,
    val video: Boolean,
    val genres: List<Genre>?,
    val spokenLanguage: List<SpokenLanguage>?,
    val collection: Collection?,
    val productionCompany: List<ProductionCompany>?,
    val productionCountry: List<ProductionCountry>?,
    val images: Images?,
    val credits: Credit?,
    val videoResponse: VideoResponse?
)
