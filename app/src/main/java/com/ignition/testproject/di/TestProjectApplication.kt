package com.ignition.testproject.di

import android.app.Application
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.di.components.DaggerAppComponent
import com.ignition.testproject.di.modules.AppModule

class TestProjectApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    fun getComponent(): AppComponent = appComponent
}