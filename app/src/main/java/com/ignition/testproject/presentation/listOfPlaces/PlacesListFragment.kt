package com.ignition.testproject.presentation.listOfPlaces

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ignition.testproject.R
import com.ignition.testproject.di.DaggerVMFactory
import com.ignition.testproject.di.components.AppComponent
import com.ignition.testproject.presentation.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_places_list.*
import javax.inject.Inject

class PlacesListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: DaggerVMFactory

    var placesRvAdapter = PlacesGroupsRVAdapter(mutableListOf())

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(PlacesListVM::class.java) }

    private lateinit var subscription: Disposable

    override fun injectFragment(appComponent: AppComponent) {
        appComponent.createPlacesListFragmentComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_places_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        places_fragment_toolbar.title = getString(R.string.places_title)
        rv_places_group.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesRvAdapter
        }

        loadPlaces()
    }

    fun loadPlaces() {
        subscription = viewModel.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    placesRvAdapter.updateData(it.placeUnions)
                    rv_places_group.adapter = placesRvAdapter
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }
}