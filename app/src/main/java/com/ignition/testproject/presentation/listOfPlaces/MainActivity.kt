package com.ignition.testproject.presentation.listOfPlaces

import android.os.Bundle
import com.ignition.testproject.R
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun injectActivity(component: AppComponent) {
        component.createMainActivityComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
