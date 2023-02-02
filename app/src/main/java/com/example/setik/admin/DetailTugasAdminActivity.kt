package com.example.setik.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.setik.Model.ReportModel
import com.example.setik.R
import kotlinx.android.synthetic.main.activity_detail_tugas_admin.*

class DetailTugasAdminActivity : AppCompatActivity() {

    private val dataTugas by lazy { intent.getSerializableExtra("data") as ReportModel.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tugas_admin)

        val kembali = findViewById<ImageView>(R.id.kembali_Detail_Tugas_admin)
        kembali.setOnClickListener {
            Intent(this@DetailTugasAdminActivity , ReportViewActivity::class.java).also {
                startActivity(it)
            }
        }
        setupView()
    }
    private fun setupView(){
        tv_det_nama_admin.setText(dataTugas.nama)
        tv_det_site_id_admin.setText(dataTugas.site_id)
        tv_det_status_admin.setText(dataTugas.status)
        tv_det_alamat_admin.setText(dataTugas.alamat)
        tv_det_tenant_admin.setText(dataTugas.tenant)
        tv_det_site_name_admin.setText(dataTugas.site_name)
        tv_det_tipe_admin.setText(dataTugas.tipe)
        tv_det_tt_number_admin.setText(dataTugas.tt_number)
    }

}