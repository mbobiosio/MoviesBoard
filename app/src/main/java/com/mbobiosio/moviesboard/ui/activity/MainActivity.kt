package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.util.navigateSearch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val searchIcon: FloatingActionButton = findViewById(R.id.search)

        searchIcon.setOnClickListener {
            navigateSearch(this)
        }

        val navController = findNavController(R.id.nav_host_fragment)
        supportActionBar?.hide()

        navView.setupWithNavController(navController)
    }
}