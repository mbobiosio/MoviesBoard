package com.mbobiosio.moviesboard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.FragmentHomeBinding
import com.mbobiosio.moviesboard.viewmodels.MoviesViewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    private val moviesViewModel by viewModels<MoviesViewModel>()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        moviesViewModel.getMovies().observe(viewLifecycleOwner) {
            Timber.d(it[0].title)
        }

    }
}