package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PlaceGroup(

        @SerializedName("Name")
        @Expose
        var name: String,

        @SerializedName("PlaceGroupSchemas")
        @Expose
        var placeGroupSchemas: List<PlaceGroupSchema>
)