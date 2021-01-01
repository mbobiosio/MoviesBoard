package com.mbobiosio.moviesboard.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityAllSeriesBinding
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.service.SeriesType
import com.mbobiosio.moviesboard.ui.adapter.AllSeriesAdapter
import com.mbobiosio.moviesboard.viewmodels.AllSeriesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AllSeriesActivity : AppCompatActivity(), (Series) -> Unit {
    private lateinit var binding : ActivityAllSeriesBinding
    private val viewModel by viewModels<AllSeriesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_series)
        binding.lifecycleOwner = this

        val seriesType = intent.getSerializableExtra("category") as SeriesType

        val adapter = AllSeriesAdapter(this)
        binding.allSeries.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(this@AllSeriesActivity, 2)
        }

        lifecycleScope.launch {
            viewModel.getPagingFlow(seriesType).collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun invoke(series: Series) {

    }
}