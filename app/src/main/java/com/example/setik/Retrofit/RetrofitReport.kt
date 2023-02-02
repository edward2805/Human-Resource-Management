package com.example.setik.Retrofit

import com.example.setik.Api.ApiReport
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitReport {

    val endpoint: ApiReport
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://172.20.10.8:8080/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(ApiReport::class.java)
    }
}