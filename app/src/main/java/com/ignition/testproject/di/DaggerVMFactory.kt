package com.ignition.testproject.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

const val UNKNOWN_CLASS_EXCEPTION_TEXT = "unknown model class"
const val UNCHECKED_CAST = "unchecked_cast"

class DaggerVMFactory @Inject constructor(
        private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
                ?: creators.asIterable().firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
                ?: throw IllegalArgumentException(UNKNOWN_CLASS_EXCEPTION_TEXT + modelClass.simpleName)

        return try {
            @Suppress(UNCHECKED_CAST)
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}