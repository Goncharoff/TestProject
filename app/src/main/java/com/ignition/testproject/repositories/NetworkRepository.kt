package com.ignition.testproject.repositories

import com.ignition.testproject.models.PlaceUnions
import io.reactivex.Single

interface NetworkRepository {
    fun getPlaces(): Single<PlaceUnions>
}