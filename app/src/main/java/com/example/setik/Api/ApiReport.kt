package com.example.setik.Api

import com.example.setik.Model.CreateModel
import com.example.setik.Model.ReportModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiReport {

    @GET("setik/karyawan/tampil_tugas.php")
    fun data() : Call<ReportModel>

    @FormUrlEncoded
    @POST("setik/crud/tambah_tugas.php")
    fun create(
        @Field("user_id")
        user_id: String,
        @Field("tt_number")
        tt_number: String,
        @Field("site_id")
        site_id: String,
        @Field("site_name")
        site_name: String,
        @Field("tenant")
        tenant: String,
        @Field("status")
        status: String,
        @Field("alamat")
        alamat: String,
        @Field("tipe")
        tipe: String
    ) : Call<CreateModel>

    @FormUrlEncoded
    @POST("setik/crud/delete.php")
    fun delete(
        @Field("id_tugas") id_tugas: String
    ) : Call<ReportModel>

}