package com.ignition.testproject.repositories

import com.ignition.testproject.datasources.network.GetPlacesAPI
import com.ignition.testproject.models.PlaceUnions
import io.reactivex.Single
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val getPlacesAPI: GetPlacesAPI) : NetworkRepository{
    override fun getPlaces(): Single<PlaceUnions>  = getPlacesAPI.getPlaces()
}