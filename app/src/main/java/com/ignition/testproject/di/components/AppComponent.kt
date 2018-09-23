package com.ignition.testproject.di.components

import android.app.Application
import com.ignition.testproject.di.modules.AppModule
import com.ignition.testproject.di.modules.NetworkModule
import com.ignition.testproject.di.modules.RepositoryModule
import com.ignition.testproject.di.modules.VMModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    VMModule::class])

@Singleton
interface AppComponent {
    fun createMainActivityComponent(): MainActivityComponent

    fun createPlacesListFragmentComponent(): PlacesListFragmentComponent

    fun createErrorFragmentComponent(): ErrorFragmentComponent

    fun inject(target: Application)
}