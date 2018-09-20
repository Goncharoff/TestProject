package com.ignition.testproject.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ignition.testproject.di.TestProjectApplication
import com.ignition.testproject.di.components.AppComponent

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (application as TestProjectApplication).getComponent()
        injectActivity(appComponent)
        super.onCreate(savedInstanceState)
    }

    abstract fun injectActivity(component: AppComponent)
}