package com.ignition.testproject.presentation.listOfPlaces

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    private val reloadAfterErrorSubscription = PublishSubject.create<Int>()

    fun notifyAboutReloadAfterError(fragmentId: Int) {
        reloadAfterErrorSubscription.onNext(fragmentId)
    }

    fun getReloadingAfterErrorNotifier(): Observable<Int> {
        return reloadAfterErrorSubscription
    }
}