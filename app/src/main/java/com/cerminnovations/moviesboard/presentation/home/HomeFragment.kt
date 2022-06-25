package com.cerminnovations.moviesboard.presentation.home

import androidx.activity.OnBackPressedCallback
import com.cerminnovations.moviesboard.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentHomeBinding
import com.cerminnovations.moviesboard.util.Constants.movieCategories
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun setupViews() {
        initViews()
    }

    private fun initViews() = with(binding) {

        movieCategories().forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it))
        }

        val adapter = HomeViewPagerAdapter(childFragmentManager, lifecycle, tabLayout.tabCount)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = movieCategories()[position]
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when {
                    tab != null -> {
                        viewPager.currentItem = tab.position
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when {
                    tab != null -> {
                        viewPager.currentItem = tab.position
                    }
                }
            }
        })

        // Handle back press
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (viewPager.currentItem == 0) {
                        activity?.finish()
                    } else {
                        viewPager.currentItem = viewPager.currentItem - 1
                    }
                }
            }
        )
    }
}
