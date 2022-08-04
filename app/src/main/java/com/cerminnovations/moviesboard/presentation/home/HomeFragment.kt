package com.cerminnovations.moviesboard.presentation.home

import android.content.Intent
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.core.constant.Constants.movieCategories
import com.cerminnovations.core.util.handleBackPress
import com.cerminnovations.moviesboard.databinding.FragmentHomeBinding
import com.cerminnovations.moviesboard.presentation.search.SearchFragment
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

        searchIcon.setOnClickListener {
            startActivity(Intent(requireContext(), SearchFragment::class.java))
        }

        movieCategories().forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it.name))
        }

        val pagerAdapter = HomeViewPagerAdapter(childFragmentManager, lifecycle, tabLayout.tabCount)
        viewPager.apply {
            adapter = pagerAdapter
            offscreenPageLimit = 4
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val title = movieCategories().map { it.name }
            tab.text = title[position]
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
        handleBackPress(viewPager)
    }
}
