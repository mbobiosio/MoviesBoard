package com.cerminnovations.moviesboard.presentation.series

import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.core.constant.Constants.seriesCategories
import com.cerminnovations.moviesboard.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SeriesFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun setupViews() {
        initViews()
    }

    // images,credits,videos

    private fun initViews() = with(binding) {
        seriesCategories().forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it.name))
        }

        val pagerAdapter = SeriesPagerAdapter(childFragmentManager, lifecycle, tabLayout.tabCount)
        viewPager.apply {
            adapter = pagerAdapter
            offscreenPageLimit = 5
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val title = seriesCategories().map { it.name }
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
    }
}
