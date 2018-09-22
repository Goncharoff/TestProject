package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PlaceUnions(

        @SerializedName("PlaceUnions")
        @Expose
        var placeUnions: List<PlaceUnion>

)