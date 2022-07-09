package com.cerminnovations.domain.listeners

import com.cerminnovations.domain.model.series.TvSeries

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface SeriesItemClickListener {
    fun onItemClick(seriesInfo: TvSeries?)
}
