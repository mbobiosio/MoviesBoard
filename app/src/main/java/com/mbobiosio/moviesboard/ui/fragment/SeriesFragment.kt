package com.mbobiosio.moviesboard.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.FragmentSeriesBinding
import com.mbobiosio.moviesboard.model.shows.Series
import com.mbobiosio.moviesboard.ui.adapter.SeriesAdapter
import com.mbobiosio.moviesboard.viewmodels.SeriesViewModel

class SeriesFragment : Fragment(), (Series) -> Unit {

    private val seriesViewModel by viewModels<SeriesViewModel>()
    private lateinit var binding: FragmentSeriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeriesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SeriesAdapter(this)

        binding.series.apply {
            binding.series.adapter = adapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        seriesViewModel.getAllSeries().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun invoke(series: Series) {

    }
}