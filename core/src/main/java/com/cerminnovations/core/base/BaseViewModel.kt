package com.cerminnovations.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
abstract class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    private var isResumed = false

    override fun onResume(owner: LifecycleOwner) {
        isResumed = true
    }

    override fun onPause(owner: LifecycleOwner) {
        isResumed = false
    }
}
