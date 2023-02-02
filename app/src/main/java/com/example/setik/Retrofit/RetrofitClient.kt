package com.example.setik.Retrofit

import com.example.setik.Api.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private fun getRetrofitClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://172.20.10.8:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getInstance(): ApiClient {
        return getRetrofitClient().create(ApiClient::class.java)
    }
}