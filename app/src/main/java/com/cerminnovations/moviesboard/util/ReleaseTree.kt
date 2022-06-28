package com.cerminnovations.moviesboard.util

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            Log.VERBOSE, Log.DEBUG -> return
        }
    }
}
