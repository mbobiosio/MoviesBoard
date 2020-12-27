package com.mbobiosio.moviesboard

import android.app.Application
import com.mbobiosio.moviesboard.util.ReleaseTree
import timber.log.Timber

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(ReleaseTree())
        }
    }

}