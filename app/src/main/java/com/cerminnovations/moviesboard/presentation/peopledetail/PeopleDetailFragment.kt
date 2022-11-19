package com.cerminnovations.moviesboard.presentation.peopledetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.core.constant.Constants.IMDB_ARTIST_URL
import com.cerminnovations.core.util.*
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.moviesboard.databinding.FragmentPersonDetailsBinding
import com.cerminnovations.moviesboard.presentation.adapter.GalleryAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PeopleDetailFragment : BaseFragment<FragmentPersonDetailsBinding>(
    FragmentPersonDetailsBinding::inflate
),
    BaseContract {

    private val args: PeopleDetailFragmentArgs by navArgs()

    private val galleryAdapter by lazy {
        GalleryAdapter()
    }

    private val viewModel by viewModels<ArtistDetailViewModel>()

    override fun setupViews() {
        lifecycle.addObserver(viewModel)
        initViews()
        observeData()
    }

    private fun initViews() = with(binding) {
        veilLayout.veil()

        backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        gallery.apply {
            layoutManager = artistsPhotosLayoutManager()
            adapter = galleryAdapter
        }
    }

    override fun observeData() {
        args.personDetail.let {
            viewModel.getPersonInfo(it)
        }

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state onLoading {
                // update progress indicator
                showProgress(isVisible = true)
            } onSuccess {
                // update ui
                showProgress(isVisible = false)
                updateUI(result)
            } onError {
                // show error
                showProgress(isVisible = false)
                showError(isError = true, error = message?.errorMessage)
            }
        }
    }

    private fun updateUI(personInfo: PersonInfo) = with(binding) {
        veilLayout.unVeil()
        person = personInfo

        galleryAdapter.submitList(personInfo.images?.profiles)

        // set click listener on imdb button
        imdbBtn.setSafeClickListener {
            IMDB_ARTIST_URL.plus(personInfo.imdbId).asUri()?.openInBrowser(requireContext())
        }
    }

    override fun showProgress(isVisible: Boolean) {
        Timber.d("Is visible $isVisible")
    }

    override fun showError(isError: Boolean, error: String?) {
        Timber.d("Failed $isError : Because $error")
    }
}
