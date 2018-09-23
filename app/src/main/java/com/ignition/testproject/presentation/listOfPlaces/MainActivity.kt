package com.ignition.testproject.presentation.listOfPlaces

import android.os.Bundle
import com.ignition.testproject.R
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.base.BaseActivity
import com.ignition.testproject.utils.NavigationRouter

const val PLACES_LIST_FRAGMENT_TAG = "places list fragment"

class MainActivity : BaseActivity() {
    override fun injectActivity(component: AppComponent) {
        component.createMainActivityComponent().inject(this)
    }

    private lateinit var navigatorRouter: NavigationRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigatorRouter = NavigationRouter(this)
        navigatorRouter.showFragment(R.id.content_frame, PlacesListFragment(), PLACES_LIST_FRAGMENT_TAG)
    }

}
