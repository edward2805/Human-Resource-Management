package com.example.setik.Model

data class CreateModel (
        val data: List<CreateModel.Data>
){
        data class Data (
                val id_tugas: String?,
                val user_id: String?,
                val tt_number: String?,
                val site_id: String?,
                val site_name: String?,
                val tenant: String?,
                val status: String?,
                val alamat: String?,
                val tipe: String?
        )
}
