package com.ignition.testproject.presentation.listOfPlaces

import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.base.BaseFragment

class PlacesListFragment : BaseFragment(){
    override fun injectFragment(appComponent: AppComponent) {
        appComponent.createPlacesListFragmentComponent().inject(this)
    }

}