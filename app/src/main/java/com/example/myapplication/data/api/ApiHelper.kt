package com.example.myapplication.data.api


class ApiHelper(private val apiService: ApiService) {

    fun getData() = apiService.getData()
    fun getEmployee() = apiService.getEmployee()


}