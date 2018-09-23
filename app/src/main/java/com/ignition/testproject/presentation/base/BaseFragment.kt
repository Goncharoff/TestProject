package com.ignition.testproject.presentation.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ignition.testproject.R
import com.ignition.testproject.di.TestProjectApplication
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.error_fragment.RETURN_FRAGMENT_ID_KEY
import com.ignition.testproject.presentation.error_fragment.RETURN_FRAGMENT_MESSAGE_KEY
import com.ignition.testproject.utils.NavigationRouter
import retrofit2.HttpException


const val RETRY_TIMES = 5
const val RETRY_DELAY = 1L

abstract class BaseFragment : Fragment() {
    private lateinit var appComponent: AppComponent
    private lateinit var connectivityManager: ConnectivityManager
    lateinit var navigatorRouter: NavigationRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (requireActivity().application as TestProjectApplication).getComponent()
        connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        navigatorRouter = NavigationRouter(requireActivity())

        injectFragment(appComponent)
        super.onCreate(savedInstanceState)
    }

    abstract fun injectFragment(appComponent: AppComponent)

    fun errorHandling(throwable: Throwable, fragmentId: Int) {
        val error = getString(R.string.error_try_again)
        when {
            throwable is HttpException ->
                when (throwable.code() / 100) {
                    4 -> showNetworkErrorFragment("$error\n ${throwable.message}", fragmentId)
                }
            connectivityManager.activeNetworkInfo?.isConnectedOrConnecting != true -> showNetworkErrorFragment(getString(R.string.check_internet), fragmentId)
            else -> showNetworkErrorFragment("$error\n ${throwable.message}", fragmentId)
        }
    }

    private fun showNetworkErrorFragment(errorMessage: String?, fragmentId: Int) {
        val bundle = Bundle()
        bundle.putInt(RETURN_FRAGMENT_ID_KEY, fragmentId)
        errorMessage?.let { bundle.putString(RETURN_FRAGMENT_MESSAGE_KEY, it) }
        navigatorRouter.navigateToNetworkErrorFragment(bundle)
    }
}