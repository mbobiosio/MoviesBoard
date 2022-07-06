package com.cerminnovations.core.util

import androidx.navigation.NavDirections

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class NavManager {
    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}
