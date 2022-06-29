package com.cerminnovations.moviesboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.ActivitySeriesDetailsBinding
import com.cerminnovations.moviesboard.model.cast.Cast
import com.cerminnovations.moviesboard.ui.adapter.CastsAdapter
import com.cerminnovations.moviesboard.util.getGenre
import com.cerminnovations.moviesboard.viewmodels.SeriesDetailViewModel
import timber.log.Timber

class SeriesDetailsActivity : AppCompatActivity(), (Cast) -> Unit {

    private val detailViewModel by viewModels<SeriesDetailViewModel>()
    private lateinit var binding: ActivitySeriesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_series_details)
        binding.lifecycleOwner = this

        val seriesId = intent.getSerializableExtra("series") as Int

        val castAdapter = CastsAdapter(this)
        binding.seriesCast.adapter = castAdapter

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        detailViewModel.getSeriesDetails(seriesId).observe(this) {
            it?.let {
                binding.seriesDetail = it
                binding.genre.text = getGenre(it.genreDtos)
                castAdapter.submitList(it.credits.casts)
                binding.executePendingBindings()
                Timber.d("${it.id}")
            }
        }
    }

    override fun invoke(cast: Cast) {
        val intent = Intent(this, ArtistDetailsActivity::class.java)
        intent.putExtra("artist", cast.id)
        startActivity(intent)
    }
}
