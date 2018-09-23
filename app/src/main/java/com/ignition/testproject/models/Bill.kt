package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Bill(

        @SerializedName("ID")
        @Expose
        var id: Int,

        @SerializedName("Number")
        @Expose
        var number: Int,

        @SerializedName("Opened")
        @Expose
        var opened: String,

        @SerializedName("Total")
        @Expose
        var total: Double,

        @SerializedName("OpenUser")
        @Expose
        var openUser: String
)