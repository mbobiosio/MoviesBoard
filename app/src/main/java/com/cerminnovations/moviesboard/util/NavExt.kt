package com.cerminnovations.moviesboard.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.cerminnovations.moviesboard.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun Fragment.navigateSafe(directions: NavDirections, navOptions: NavOptions? = null) {
    if (canNavigate()) findNavController().navigate(directions, navOptions)
}

/**
 * Returns true if the navigation controller is still pointing at 'this' fragment, or false
 * if it already navigated away.
 */
fun Fragment.canNavigate(): Boolean {
    val navController = findNavController()
    val destinationIdInNavController = navController.currentDestination?.id

    // add tag_navigation_destination_id to your res\values\ids.xml so that it's unique:
    val destinationIdOfThisFragment =
        view?.getTag(R.id.tag_navigation_destination_id) ?: destinationIdInNavController

    // check that the navigation graph is still in 'this' fragment, if not then the app already navigated:
    return when (destinationIdInNavController) {
        destinationIdOfThisFragment -> {
            view?.setTag(R.id.tag_navigation_destination_id, destinationIdOfThisFragment)
            true
        }
        else -> {
            Timber.d("May not navigate: current destination is not the current fragment.")
            false
        }
    }
}

fun visibleNavElements(navController: NavController, bottomNav: BottomNavigationView?) {
    navController.addOnDestinationChangedListener { _, destination, _ ->
        when (destination.id) {
            // R.id.firstLaunchFragment -> bottomNav?.visibility = View.GONE
            else -> bottomNav?.visibility = View.VISIBLE
        }
    }
}
