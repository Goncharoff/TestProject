package com.ignition.testproject.di.components

import com.ignition.testproject.di.modules.PlacesListFragmentScope
import com.ignition.testproject.presentation.listOfPlaces.PlacesListFragment
import dagger.Subcomponent

@PlacesListFragmentScope
@Subcomponent(modules = [PlacesListFragment::class])
interface PlacesListFragmentComponent {
    fun inject(target: PlacesListFragment)
}