package com.ignition.testproject.utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.ignition.testproject.R
import com.ignition.testproject.presentation.error_fragment.ErrorNetworkFragment

class NavigationRouter(activity: FragmentActivity) {
    val supportFragmentManager = activity.supportFragmentManager
    val fragmentContainer: Int = R.id.content_frame

    fun showFragment(fragmentContainer: Int, fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.beginTransaction()
                .replace(fragmentContainer, fragment, fragmentTag)
                .commit()
    }

    fun navigateToNetworkErrorFragment(bundle: Bundle) {
        val errorFragment = ErrorNetworkFragment()
        errorFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
                .replace(fragmentContainer, errorFragment)
                .commit()
    }

    fun navigateToFragmentById(fragmentId: Int, bundle: Bundle? = null, withoutCanReturnBack: Boolean = false) {
        popBackStackIfNeed(withoutCanReturnBack)
        val destinationFragment = supportFragmentManager.findFragmentById(fragmentId)!!
        destinationFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
                .replace(fragmentContainer, destinationFragment)
                .commit()
    }

    private fun popBackStackIfNeed(needPopBackStack: Boolean) {
        if (needPopBackStack) {
            supportFragmentManager.popBackStack()
        }
    }

    fun getCurrentFragmentId(): Int? = supportFragmentManager.findFragmentById(R.id.content_frame)!!.id
}