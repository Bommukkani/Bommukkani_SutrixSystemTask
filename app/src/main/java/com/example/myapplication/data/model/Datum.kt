package com.example.myapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Datum {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    private var isSelected = false

    fun setSelected(selected: Boolean) {
        isSelected = selected
    }


    fun isSelected(): Boolean {
        return isSelected
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true

        if (other !is Datum) {
            return false
        }

        val datum: Datum = other

        return datum.id?.equals(id)!!
    }

    override fun hashCode(): Int {
        return id!!
    }


}