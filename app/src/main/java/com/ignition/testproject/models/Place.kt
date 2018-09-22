package com.ignition.testproject.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Place(

        @SerializedName("Name")
        @Expose
        var name: String,

        @SerializedName("Code")
        @Expose
        var code: String,

        @SerializedName("Left")
        @Expose
        var left: Int,

        @SerializedName("Top")
        @Expose
        var top: Int,

        @SerializedName("Width")
        @Expose
        var width: Int,

        @SerializedName("Height")
        @Expose
        var height: Int,

        @SerializedName("Corner")
        @Expose
        var corner: Int,

        @SerializedName("ShapeType")
        @Expose
        var shapeType: Int,

        @SerializedName("ShapeOrient")
        @Expose
        var shapeOrient: Int,

        @SerializedName("Color")
        @Expose
        var color: Int,

        @SerializedName("Style")
        @Expose
        var style: Int,

        @SerializedName("FrameColor")
        @Expose
        var frameColor: Int,

        @SerializedName("FontColor")
        @Expose
        var fontColor: Int,

        @SerializedName("Bills")
        @Expose
        var bills: List<Bill>
)
