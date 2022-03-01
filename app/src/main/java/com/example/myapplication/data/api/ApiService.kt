package com.example.myapplication.data.api

import com.example.myapplication.data.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET("challenge-services/")
    fun getData() : Call<Data>

    @GET("challenge-employees/")
    fun getEmployee() : Call<Data>


}