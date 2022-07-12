package com.cerminnovations.moviesboard.presentation.people

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PeopleFragment :
    BaseFragment<FragmentPeopleBinding>(
        FragmentPeopleBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<PeopleViewModel>()
    private val peopleAdapter by lazy {
        PeopleAdapter()
    }

    override fun setupViews() {
        initRecyclerView()
        observeData()
    }

    private fun initRecyclerView() = with(binding) {
        people.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            adapter = peopleAdapter
        }
    }

    override fun observeData() {
        viewModel.getPeople().observe(viewLifecycleOwner) {
            peopleAdapter.submitData(lifecycle, it)
        }
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
