package com.ignition.testproject.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class NavigationRouter(activity: FragmentActivity) {
    val supportFragmentManager = activity.supportFragmentManager

    fun showFragment(fragmentContainer: Int, fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.beginTransaction()
                .replace(fragmentContainer, fragment, fragmentTag)
                .commit()
    }
}