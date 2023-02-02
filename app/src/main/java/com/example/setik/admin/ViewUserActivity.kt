package com.example.setik.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.setik.Model.KaryawanModel
import com.example.setik.R
import kotlinx.android.synthetic.main.activity_view_user.*

class ViewUserActivity : AppCompatActivity() {

    private val karyawan by lazy { intent.getSerializableExtra("Karyawan") as KaryawanModel.DataKary }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)
        setUpView()

        val kembali = findViewById<ImageView>(R.id.kembali_detail_data_karyawan)
        kembali.setOnClickListener {
            Intent(this@ViewUserActivity , DataKaryawan::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun setUpView() {
        tv_det_nama_karyawan.setText(karyawan.nama)
        tv_det_username_karyawan.setText(karyawan.username)
        tv_det_alamat_karyawan.setText(karyawan.alamat)
        tv_det_no_hp_karyawan.setText(karyawan.no_tlp)
    }
}