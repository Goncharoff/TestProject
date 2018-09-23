package com.ignition.testproject.di.components

import com.ignition.testproject.di.modules.MainActivityModule
import com.ignition.testproject.di.modules.MainActivityScope
import com.ignition.testproject.presentation.listOfPlaces.MainActivity
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}