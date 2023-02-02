package com.example.setik.Model

import java.io.Serializable

class KaryawanModel (
    val datakar: ArrayList<DataKary>
        ) {
    data class DataKary(
        val id: String?,
        val nama: String?,
        val username: String?,
        val level_user: String?,
        val alamat: String?,
        val no_tlp: String?
    ) : Serializable
}