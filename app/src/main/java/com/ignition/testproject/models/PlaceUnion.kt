package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlaceUnion(

        @SerializedName("Name")
        @Expose
        val name: String,

        @SerializedName("PlaceGroup")
        @Expose
        val placeGroups: MutableList<PlaceGroup>
)