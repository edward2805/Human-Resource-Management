package com.example.setik.Model

import java.io.Serializable


data class TugasUserModel (
    val id_tugas: String?,
    val user_id: String?,
    val nama: String?,
    val tt_number: String?,
    val site_id: String?,
    val site_name: String?,
    val tenant: String?,
    val status: String?,
    val alamat:String?,
    val tipe: String?

    ) : Serializable