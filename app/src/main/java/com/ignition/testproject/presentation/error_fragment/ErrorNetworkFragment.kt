package com.ignition.testproject.presentation.error_fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ignition.testproject.R
import com.ignition.testproject.di.DaggerVMFactory
import com.ignition.testproject.di.TestProjectApplication
import com.ignition.testproject.presentation.listOfPlaces.MainActivity
import com.ignition.testproject.presentation.listOfPlaces.MainViewModel
import com.ignition.testproject.utils.NavigationRouter
import kotlinx.android.synthetic.main.fragment_error_network.*
import javax.inject.Inject

const val RETURN_FRAGMENT_MESSAGE_KEY = "returnFragmentMessage"
const val RETURN_FRAGMENT_ID_KEY = "returnFragmentId"
const val RETURN_FRAGMENT_BUNDLE_KEY = "returnFragmentBundle"

private const val NETWORK_SETTINGS_ERROR_CODE = 2

class ErrorNetworkFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: DaggerVMFactory

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory)
                .get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (requireActivity().application as TestProjectApplication).getComponent()
                .createErrorFragmentComponent().inject(this)
        return inflater.inflate(R.layout.fragment_error_network, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(RETURN_FRAGMENT_MESSAGE_KEY, null)?.let {
            network_error.text = it
        }
        retry.setOnClickListener {
            val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager.activeNetworkInfo?.isConnectedOrConnecting != true) {
                startActivityForResult(Intent(Settings.ACTION_WIFI_SETTINGS), NETWORK_SETTINGS_ERROR_CODE)
            } else returnToTargetFragment()
        }
    }

    private fun returnToTargetFragment() {
        if (arguments?.getInt(RETURN_FRAGMENT_ID_KEY) == null) {
            startActivity(Intent(this.context, MainActivity::class.java))
        } else {
            val returnFragmentId = (arguments?.getInt(RETURN_FRAGMENT_ID_KEY)
                    ?: throw IllegalArgumentException("returnFragmentId must be non null!"))

            viewModel.notifyAboutReloadAfterError(returnFragmentId)

            val returnFragmentBundle = arguments?.getBundle(RETURN_FRAGMENT_BUNDLE_KEY)
            NavigationRouter(requireActivity()).navigateToFragmentById(returnFragmentId, returnFragmentBundle, true)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == NETWORK_SETTINGS_ERROR_CODE) {
            returnToTargetFragment()
        }
    }
}