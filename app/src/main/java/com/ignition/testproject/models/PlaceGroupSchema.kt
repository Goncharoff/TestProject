package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PlaceGroupSchema(

        @SerializedName("Name")
        @Expose
        var name: String,

        @SerializedName("Places")
        @Expose
        var places: List<Place>
)