package com.cerminnovations.moviesboard.ui.fragment

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
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.FragmentHomeBinding
import com.cerminnovations.moviesboard.model.movies.Movie
import com.cerminnovations.moviesboard.service.MovieType
import com.cerminnovations.moviesboard.ui.activity.AllMoviesActivity
import com.cerminnovations.moviesboard.ui.adapter.MovieAdapter
import com.cerminnovations.moviesboard.util.DEFAULT_MOVIES_TYPE
import com.cerminnovations.moviesboard.util.navigateMovieDetails
import com.cerminnovations.moviesboard.viewmodels.MoviesViewModel
import com.mohamedabulgasem.loadingoverlay.LoadingAnimation
import com.mohamedabulgasem.loadingoverlay.LoadingOverlay

class HomeFragment : Fragment(), (Movie) -> Unit {

    private val moviesViewModel by viewModels<MoviesViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private var movieType = DEFAULT_MOVIES_TYPE
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //show loading overlay
        loadingOverlay.show()

        val adapter = MovieAdapter(this)
        binding.movies.apply {
            binding.movies.adapter = adapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        moviesViewModel.getMovies().observe(viewLifecycleOwner) {
            //hide loading overlay
            loadingOverlay.dismiss()
            //submit list to list adapter
            adapter.submitList(it)
        }

        binding.categories.apply {
            lifecycleOwner = this@HomeFragment
            setOnSpinnerItemSelectedListener<String> { _, _, newIndex, newItem ->
                movieType = when (newIndex) {
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