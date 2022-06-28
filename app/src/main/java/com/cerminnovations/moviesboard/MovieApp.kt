package com.cerminnovations.moviesboard

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.cerminnovations.moviesboard.util.ReleaseTree
import timber.log.Timber

class MovieApp : MultiDexApplication() {

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

    override fun attachBaseContext(base: Context?) {
        MultiDex.install(this)
        super.attachBaseContext(base)
    }
}
