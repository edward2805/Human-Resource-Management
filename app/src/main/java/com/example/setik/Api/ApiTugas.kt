package com.example.setik.Api

import com.example.setik.Model.TugasUserModel
import retrofit2.Call
import retrofit2.http.*

interface ApiTugas {

    @GET("setik/crud/tampil_data_user.php")
    fun TugasUser ( @Query ("user_id") user_id: Int )
    : Call<ArrayList<TugasUserModel>>

    @FormUrlEncoded
    @POST("setik/crud/edit_tugas.php")
    fun update(
        @Field("id_tugas")
        id_tugas: String,
        @Field("status")
        status: String
    ) : Call<ArrayList<TugasUserModel>>

}