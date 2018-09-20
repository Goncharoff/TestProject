package com.ignition.testproject.di.components

import android.app.Application
import com.ignition.testproject.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])

@Singleton
interface AppComponent {
    fun createMainActivityComponent(): MainActivityComponent

    fun inject(target: Application)
}