package com.cerminnovations.moviesboard.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.data.remote.model.cast.SeriesCastDto
import com.cerminnovations.moviesboard.databinding.FragmentPersonDetailsBinding

class ArtistDetailsActivity : AppCompatActivity(), (Any) -> Unit {
    private lateinit var binding: FragmentPersonDetailsBinding

    // private val detailViewModel by viewModels<ArtistDetailViewModel>()
    private var imdbLink = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_person_details)
        binding.lifecycleOwner = this

        val artistId = intent.getSerializableExtra("artist") as Int

        // binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        /*See all Artist Movies*/
        // binding.textView20.setOnClickListener {
        // navigateArtistCasts(this, artistId, "movies")
        // }

        /*See all Artist Series*/
        // binding.textView21.setOnClickListener {
        // navigateArtistCasts(this, artistId, "series")
        // }

        /*detailViewModel.uiState.observe(this) { state ->
            state onLoading {
            } onSuccess {
            } onError {
            }
        }*/

        /*Go to IMDB Page*/
        // binding.imdb.setOnClickListener {
        // IMDB_ARTIST_URL.plus(imdbLink).asUri()?.openInBrowser(this)
        // }
    }

    override fun invoke(any: Any) {
        when (any) {
            is MovieCastDto -> {
                // navigateMovieDetails(any.id!!)
            }
            is SeriesCastDto -> {
                // navigateSeriesDetails(any.id)
            }
        }
    }
}
