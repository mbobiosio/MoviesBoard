package com.cerminnovations.moviesboard.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.ActivityMainBinding
import com.cerminnovations.moviesboard.util.NavManager
import com.cerminnovations.moviesboard.util.navigateSafe
import com.cerminnovations.moviesboard.util.visibleNavElements
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController get() = findNavController(R.id.nav_host_fragment)

    private val navManager by lazy {
        NavManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() = with(binding) {
        navView.setupWithNavController(navController)
        navView.setOnItemReselectedListener { }

        visibleNavElements(navController, navView)

        navManager.setOnNavEvent {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)
            currentFragment?.navigateSafe(it)
        }
    }
}
