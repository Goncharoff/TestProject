package com.ignition.testproject.datasources.network

import com.ignition.testproject.models.PlaceUnions
import io.reactivex.Single
import retrofit2.http.Headers
import retrofit2.http.POST

interface GetPlacesAPI {
    @Headers(
            "accept: application/json",
            "content-type: application/json"
    )
    @POST("GetPlaces")
    fun getPlaces(): Single<PlaceUnions>
}