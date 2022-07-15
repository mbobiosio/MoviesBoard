package com.cerminnovations.moviesboard.presentation.peopledetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.core.util.onError
import com.cerminnovations.core.util.onLoading
import com.cerminnovations.core.util.onSuccess
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.moviesboard.databinding.FragmentPersonDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PeopleDetailFragment :
    BaseFragment<FragmentPersonDetailsBinding>(
        FragmentPersonDetailsBinding::inflate
    ),
    BaseContract {

    private val args: PeopleDetailFragmentArgs by navArgs()

    private val viewModel by viewModels<ArtistDetailViewModel>()

    override fun setupViews() {
        initViews()
        observeData()
    }

    private fun initViews() = with(binding) {
        veilLayout.veil()
    }

    override fun observeData() {
        args.personDetail?.let {
            viewModel.getPersonInfo(it.id)
        }

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state onLoading {
                // update progress indicator
                showProgress(isVisible = true)
            } onSuccess {
                // update ui
                updateUI(result)
            } onError {
                // show error
                showError(isError = true, error = message?.errorMessage)
            }
        }
    }

    private fun updateUI(personInfo: PersonInfo) = with(binding) {
        veilLayout.unVeil()
        person = personInfo
        Timber.d("Info ${personInfo.movieCredits?.cast?.size} : ${personInfo.seriesCredits?.cast?.size}")
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
