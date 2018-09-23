package com.ignition.testproject.di.components

import com.ignition.testproject.di.modules.ErrorFragmentModule
import com.ignition.testproject.di.modules.ErrorFragmentScope
import com.ignition.testproject.presentation.error_fragment.ErrorNetworkFragment
import dagger.Subcomponent

@ErrorFragmentScope
@Subcomponent(modules = [ErrorFragmentModule::class])
interface ErrorFragmentComponent {
    fun inject(target: ErrorNetworkFragment)
}