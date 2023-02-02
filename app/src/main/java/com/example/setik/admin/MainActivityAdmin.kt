package com.example.setik.admin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.setik.LoginActivity
import com.example.setik.R
import com.example.setik.databinding.ActivityMainAdminBinding


class MainActivityAdmin : AppCompatActivity(), View.OnClickListener {
    private var binding : ActivityMainAdminBinding? = null
    private lateinit var profil : SharedPreferences

    private val nama by lazy { intent.getStringExtra("user") }
    private lateinit var btncreate : CardView
    private lateinit var btnTugas : CardView
    private lateinit var btnviewkaryawan : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAdminBinding.inflate(layoutInflater)
        setContentView(binding?.root)


//      menampilkan nama user
        profil = getSharedPreferences("login_session", MODE_PRIVATE)
        binding?.tvnama?.text = profil.getString("nama", null)

//      membuat fungsi tombol keluar
        binding?.imkeluar?.setOnClickListener{
            // menghapus session
            profil.edit().clear().commit()

            startActivity(Intent(this@MainActivityAdmin, LoginActivity::class.java))
            finish()
        }

        val btn_view : CardView = findViewById(R.id.cvview)
        btn_view.setOnClickListener(this)


        btnviewkaryawan = findViewById(R.id.cvdatakar)
        btnviewkaryawan.setOnClickListener{
            startActivity(Intent(this, DataKaryawan::class.java))
        }

        btncreate = findViewById(R.id.cvcreate)
        btncreate.setOnClickListener{
            startActivity(Intent(this, CreateReportActivity::class.java))
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.cvview -> {
                    val pindahIntent = Intent(this, ReportViewActivity::class.java)
                    startActivity(pindahIntent)
                }
            }
        }
    }
}