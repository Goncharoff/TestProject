package com.ignition.testproject.presentation.listOfPlaces

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.ignition.testproject.R
import com.ignition.testproject.di.DaggerVMFactory
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.base.BaseActivity
import com.ignition.testproject.utils.NavigationRouter
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

const val PLACES_LIST_FRAGMENT_TAG = "places list fragment"

class MainActivity : BaseActivity() {
    override fun injectActivity(component: AppComponent) {
        component.createMainActivityComponent().inject(this)
    }

    @Inject
    lateinit var viewModelFactory: DaggerVMFactory

    private val viewModel: MainViewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    lateinit var navigatorRouter: NavigationRouter

    private lateinit var subscriptionOnReloadingAfterError: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigatorRouter = NavigationRouter(this)
        navigatorRouter.showFragment(R.id.content_frame, PlacesListFragment(), PLACES_LIST_FRAGMENT_TAG)

        subscriptionOnReloadingAfterError = viewModel.getReloadingAfterErrorNotifier()
                .observeOn(Schedulers.io())
                .subscribe()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun onDestroy() {
        subscriptionOnReloadingAfterError.dispose()
        super.onDestroy()
    }

}