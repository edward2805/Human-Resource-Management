package com.example.setik.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.setik.MainActivity
import com.example.setik.Model.CreateModel
import com.example.setik.R
import com.example.setik.Retrofit.RetrofitReport
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateReportActivity : AppCompatActivity() {

        private lateinit var etuser : EditText
        private lateinit var ettt_number : EditText
        private lateinit var et_site_id : EditText
        private lateinit var et_site_name : EditText
        private lateinit var et_tenant : EditText
        private lateinit var et_status : Spinner
        private lateinit var et_alamat : EditText
        private lateinit var et_tipe : EditText
        private lateinit var button_create : MaterialButton

        private val api by lazy { RetrofitReport().endpoint }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_report)

        val kembali = findViewById<ImageView>(R.id.kembali_create_tugas_admin)
        kembali.setOnClickListener {
            Intent(this@CreateReportActivity , MainActivityAdmin::class.java).also {
                startActivity(it)
            }
        }

        setupView()
        setupListener()

    }

    private fun setupView(){
        etuser = findViewById(R.id.etuser_id)
        ettt_number = findViewById(R.id.ettt_number)
        et_site_id = findViewById(R.id.etsite_id)
        et_site_name = findViewById(R.id.etsite_name)
        et_tenant = findViewById(R.id.ettenant)
        et_status = findViewById(R.id.etstatus)
        et_alamat = findViewById(R.id.etalamat)
        et_tipe = findViewById(R.id.ettipe)

        button_create = findViewById(R.id.btn_submit)
    }
    private fun setupListener(){
        button_create.setOnClickListener {
            if (etuser.text.toString().isNotEmpty() &&
                ettt_number.text.toString().isNotEmpty() &&
                et_site_id.text.toString().isNotEmpty() &&
                et_site_name.text.toString().isNotEmpty() &&
                et_tenant.text.toString().isNotEmpty() &&
                et_alamat.text.toString().isNotEmpty() &&
                et_tipe.text.toString().isNotEmpty()){
                Log.e("CreateReportActivity", etuser.text.toString())
                Log.e("CreateReportActivity", ettt_number.text.toString())
                api.create(
                    etuser.text.toString(),
                    ettt_number.text.toString(),
                    et_site_id.text.toString(),
                    et_site_name.text.toString(),
                    et_tenant.text.toString(),
                    et_status.selectedItem.toString(),
                    et_alamat.text.toString(),
                    et_tipe.text.toString(),)
                    .enqueue(object :Callback<CreateModel>{
                        override fun onResponse(
                            call: Call<CreateModel>,
                            response: Response<CreateModel>
                        ) {
                            if(response.isSuccessful){
                                SweetAlertDialog(this@CreateReportActivity, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("Selamat!")
                                    .setContentText("Berhasil Tambah Tugas")
                                    .setConfirmClickListener(
                                        {
                                            val intent = Intent(this@CreateReportActivity, MainActivityAdmin::class.java)
                                            startActivity(intent)
                                            finish()
                                        })
                                    .show()
                            }
                        }
                        override fun onFailure(call: Call<CreateModel>, t: Throwable) {
                        }

                    })
            }else {
                Toast.makeText(
                    applicationContext, "Form Tidak Boleh Kosong", Toast.LENGTH_LONG
                ).show()
            }

        }
    }

}
