package com.mbobiosio.moviesboard.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.FragmentArtistsBinding
import com.mbobiosio.moviesboard.model.artists.Artist
import com.mbobiosio.moviesboard.ui.adapter.ArtistsAdapter
import com.mbobiosio.moviesboard.viewmodels.ArtistsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class ArtistsFragment : Fragment(), (Artist) -> Unit {
    private lateinit var binding: FragmentArtistsBinding
    private val artistsViewModel by viewModels<ArtistsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArtistsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistsAdapter = ArtistsAdapter(this)
        binding.artists.apply {
            this.adapter = artistsAdapter
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
        }

        lifecycleScope.launch {
            artistsViewModel.artistPaging.collectLatest {
                artistsAdapter.submitData(it)
            }
        }
    }

    override fun invoke(artist: Artist) {
        Timber.d(artist.name)
    }
}