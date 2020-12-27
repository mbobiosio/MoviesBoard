package com.mbobiosio.moviesboard.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.FragmentHomeBinding
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.service.MovieType
import com.mbobiosio.moviesboard.ui.activity.AllMoviesActivity
import com.mbobiosio.moviesboard.ui.adapter.MovieAdapter
import com.mbobiosio.moviesboard.viewmodels.MoviesViewModel
import timber.log.Timber

class HomeFragment : Fragment(), (Movie) -> Unit {

    private val moviesViewModel by viewModels<MoviesViewModel>()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter(this)
        binding.movies.adapter = adapter

        GridLayoutManager(activity, 2).apply {
            binding.movies.layoutManager = this
        }

        moviesViewModel.getMovies().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.viewAll.setOnClickListener {
            val intent = Intent(activity, AllMoviesActivity::class.java)
            activity?.startActivity(intent)
        }

        binding.categories.setOnSpinnerItemSelectedListener<String> { _, _, newIndex, newItem ->

            val queryType = when(newIndex) {
                0 -> MovieType.POPULAR
                1 -> MovieType.TOP_RATED
                2 -> MovieType.UPCOMING
                3 -> MovieType.NOW_PLAYING
                4 -> MovieType.TRENDING_WEEKLY
                else -> MovieType.POPULAR
            }

            binding.textHome.text= newItem
            moviesViewModel.updateMovieType(queryType)
        }

    }

    private fun navigateCollection(queryType: MovieType) {

    }

    override fun invoke(movie: Movie) {
        Timber.d(movie.title)
    }

}