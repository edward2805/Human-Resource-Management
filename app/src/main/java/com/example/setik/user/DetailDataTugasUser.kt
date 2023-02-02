package com.example.setik.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Spinner
import com.example.setik.Model.TugasUserModel
import com.example.setik.R
import com.example.setik.Retrofit.RetrofitTugasUser
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_detail_data_tugas_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailDataTugasUser : AppCompatActivity() {

    private lateinit var button_edit : MaterialButton
    private lateinit var tv_det_status_user : Spinner
    private val api by lazy { RetrofitTugasUser().endpoint }

    private val dataTugas by lazy { intent.getSerializableExtra("tugas_user") as TugasUserModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data_tugas_user)

        button_edit = findViewById(R.id.btn_edit_submit)
        tv_det_status_user = findViewById(R.id.tv_det_status_user)

        setupView()
        setupListener()

        val kembali = findViewById<ImageView>(R.id.kembali_edit_tugas_user)
        kembali.setOnClickListener {
            Intent(this@DetailDataTugasUser , ViewDataTugasUser::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun setupView() {
        tv_det_id_tugas_user.setText(dataTugas.id_tugas)
        tv_det_nama_user.setText(dataTugas.nama)
        tv_det_tt_number_user.setText(dataTugas.tt_number)
        tv_det_site_id_user.setText(dataTugas.site_id)
        tv_det_site_name_user.setText(dataTugas.site_name)
        tv_det_tenant_user.setText(dataTugas.tenant)
        tv_det_alamat_user.setText(dataTugas.alamat)
        tv_det_tipe_user.setText(dataTugas.tipe)

    }

    private fun setupListener(){
        button_edit.setOnClickListener {
            api.update(tv_det_id_tugas_user.text.toString(), tv_det_status_user.selectedItem.toString() )
                .enqueue(object : Callback<ArrayList<TugasUserModel>>{
                    override fun onResponse(
                        call: Call<ArrayList<TugasUserModel>>,
                        response: Response<ArrayList<TugasUserModel>>
                    ) {
                        if(response.isSuccessful){
                            startActivity(Intent
                                (this@DetailDataTugasUser, ViewDataTugasUser::class.java))
                            finish()
                        }
                    }
                    override fun onFailure(call: Call<ArrayList<TugasUserModel>>, t: Throwable) {
                        startActivity(Intent
                            (this@DetailDataTugasUser, ViewDataTugasUser::class.java))
                        finish()
                    }

                })
            }
    }
}