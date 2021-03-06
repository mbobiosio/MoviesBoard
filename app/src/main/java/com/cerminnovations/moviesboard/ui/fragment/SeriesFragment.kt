package com.cerminnovations.moviesboard.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.FragmentSeriesBinding
import com.cerminnovations.moviesboard.model.shows.Series
import com.cerminnovations.moviesboard.service.SeriesType
import com.cerminnovations.moviesboard.ui.activity.AllSeriesActivity
import com.cerminnovations.moviesboard.ui.adapter.SeriesAdapter
import com.cerminnovations.moviesboard.util.DEFAULT_SERIES_TYPE
import com.cerminnovations.moviesboard.util.navigateSeriesDetails
import com.cerminnovations.moviesboard.viewmodels.SeriesViewModel
import com.mohamedabulgasem.loadingoverlay.LoadingAnimation
import com.mohamedabulgasem.loadingoverlay.LoadingOverlay

class SeriesFragment : Fragment(), (Series) -> Unit {

    private val seriesViewModel by viewModels<SeriesViewModel>()
    private lateinit var binding: FragmentSeriesBinding
    private var seriesType = DEFAULT_SERIES_TYPE
    private val loadingOverlay: LoadingOverlay by lazy {
        LoadingOverlay.with(
            context = requireActivity(),
            isCancellable = true,
            animation = LoadingAnimation(
                rawRes = R.raw.blast,
                dimens = 200
            )
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeriesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //show loading overlay
        loadingOverlay.show()

        val adapter = SeriesAdapter(this)

        binding.series.apply {
            binding.series.adapter = adapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        binding.categories.apply {
            lifecycleOwner = this@SeriesFragment
            setOnSpinnerItemSelectedListener<String> { _, _, newIndex, newItem ->
                seriesType = when(newIndex){
                    0 -> SeriesType.POPULAR
                    1 -> SeriesType.TOP_RATED
                    2 -> SeriesType.NOW_SHOWING
                    3 -> SeriesType.SHOWING_TODAY
                    5 -> SeriesType.TRENDING_TODAY
                    4 -> SeriesType.TRENDING_THIS_WEEK
                    else -> SeriesType.POPULAR
                }
                binding.textHome.text = newItem
                seriesViewModel.updateSeriesType(seriesType)
            }
        }

        seriesViewModel.getAllSeries().observe(viewLifecycleOwner) {
            //hide loading overlay
            loadingOverlay.dismiss()
            //submit list to list adapter
            adapter.submitList(it)
        }

        binding.viewAll.setOnClickListener {
            val intent = Intent(activity, AllSeriesActivity::class.java)
            intent.putExtra("category", seriesType)
            activity?.startActivity(intent)
        }
    }

    override fun invoke(series: Series) {
        navigateSeriesDetails(activity, series.id)
    }
}