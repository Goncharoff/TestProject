package com.ignition.testproject.presentation.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ignition.testproject.di.TestProjectApplication
import com.ignition.testproject.di.components.AppComponent

abstract class BaseFragment : Fragment() {
    private lateinit var appComponent: AppComponent
    private lateinit var connectivityManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (requireActivity().application as TestProjectApplication).getComponent()
        connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        super.onCreate(savedInstanceState)
    }

    abstract fun injectFragment(appComponent: AppComponent)
}