package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivitySeriesDetailsBinding
import com.mbobiosio.moviesboard.model.cast.Cast
import com.mbobiosio.moviesboard.ui.adapter.CastsAdapter
import com.mbobiosio.moviesboard.ui.adapter.GenreAdapter
import com.mbobiosio.moviesboard.viewmodels.SeriesDetailViewModel
import timber.log.Timber

class SeriesDetailsActivity : AppCompatActivity(), (Cast) -> Unit {

    private val detailViewModel by viewModels<SeriesDetailViewModel>()
    private lateinit var binding: ActivitySeriesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_series_details)
        binding.lifecycleOwner = this

        val seriesId = intent.getSerializableExtra("series") as Int

        val genreAdapter = GenreAdapter()
        val castAdapter = CastsAdapter(this)
        binding.genre.adapter = genreAdapter
        binding.seriesCast.adapter = castAdapter

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        detailViewModel.getSeriesDetails(seriesId).observe(this) {
            it?.let {
                binding.seriesDetail = it
                genreAdapter.submitList(it.genres)
                castAdapter.submitList(it.credits.casts)
                binding.executePendingBindings()
                Timber.d("${it.id}")
            }
        }
    }

    override fun invoke(cast: Cast) {

    }
}