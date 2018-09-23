package com.ignition.testproject.presentation.listOfPlaces

import android.arch.lifecycle.ViewModel
import com.ignition.testproject.repositories.NetworkRepository
import javax.inject.Inject

class PlacesListVM @Inject constructor(private val networkRepository: NetworkRepository) : ViewModel() {
    fun getPlaces() = networkRepository.getPlaces()
}