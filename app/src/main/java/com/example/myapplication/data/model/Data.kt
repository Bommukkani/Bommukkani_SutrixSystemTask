package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Data {
    @SerializedName("responseCode")
    @Expose
    var responseCode: Int? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null
}