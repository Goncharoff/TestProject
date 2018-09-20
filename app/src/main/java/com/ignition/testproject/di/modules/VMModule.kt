package com.ignition.testproject.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ignition.testproject.di.DaggerVMFactory
import com.ignition.testproject.di.ViewModelKey
import com.ignition.testproject.presentation.listOfPlaces.PlacesListVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class VMModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: DaggerVMFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PlacesListVM::class)
    internal abstract fun bindPlacesListVM(placesListVM: PlacesListVM): ViewModel
}