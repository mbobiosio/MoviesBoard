package com.mbobiosio.moviesboard.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mbobiosio.moviesboard.databinding.FragmentHomeBinding
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.service.MovieType
import com.mbobiosio.moviesboard.ui.activity.AllMoviesActivity
import com.mbobiosio.moviesboard.ui.adapter.MovieAdapter
import com.mbobiosio.moviesboard.util.DEFAULT_MOVIES_TYPE
import com.mbobiosio.moviesboard.util.navigateMovieDetails
import com.mbobiosio.moviesboard.viewmodels.MoviesViewModel

class HomeFragment : Fragment(), (Movie) -> Unit {

    private val moviesViewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private var movieType = DEFAULT_MOVIES_TYPE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter(this)
        binding.movies.apply {
            binding.movies.adapter = adapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        moviesViewModel.getMovies().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.categories.apply {
            lifecycleOwner = this@HomeFragment
            setOnSpinnerItemSelectedListener<String> { _, _, newIndex, newItem ->
                movieType = when(newIndex){
                    0 -> MovieType.POPULAR
                    1 -> MovieType.TOP_RATED
                    2 -> MovieType.UPCOMING
                    3 -> MovieType.NOW_PLAYING
                    4 -> MovieType.TRENDING_THIS_WEEK
                    else -> MovieType.POPULAR
                }
                binding.textHome.text = newItem
                moviesViewModel.updateMovieType(movieType)
            }

            setOnSpinnerOutsideTouchListener { _, motionEvent ->
                if (motionEvent.actionButton == 0) {
                    binding.categories.dismiss()
                }
            }
        }

        binding.viewAll.setOnClickListener {
            val intent = Intent(activity, AllMoviesActivity::class.java)
            intent.putExtra("category", movieType)
            activity?.startActivity(intent)
        }
    }

    override fun invoke(movie: Movie) {
        navigateMovieDetails(activity, movie.id)
    }
}