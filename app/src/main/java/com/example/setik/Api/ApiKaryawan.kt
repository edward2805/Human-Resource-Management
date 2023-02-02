package com.example.setik.Api

import com.example.setik.Model.KaryawanModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiKaryawan {
    @GET("setik/crud/dataKar.php")
    fun dataKrywn() : Call<KaryawanModel>
}