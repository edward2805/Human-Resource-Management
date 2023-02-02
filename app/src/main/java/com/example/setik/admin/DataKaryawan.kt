package com.example.setik.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.setik.Adapter.DataKaryawanAdapter
import com.example.setik.Model.KaryawanModel
import com.example.setik.R
import com.example.setik.Retrofit.RetrofitKaryawan
import kotlinx.android.synthetic.main.activity_data_karyawan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataKaryawan : AppCompatActivity() {

    private val TAG1 : String = "DataKaryawan"

    private val api by lazy { RetrofitKaryawan().endpoint }
    private lateinit var dataKaryawanAdapter: DataKaryawanAdapter
    private lateinit var listKaryawan: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_karyawan)

        val kembali = findViewById<ImageView>(R.id.kembali_data_karyawan)
        kembali.setOnClickListener {
            Intent(this@DataKaryawan , MainActivityAdmin::class.java).also {
                startActivity(it)
            }
        }
    }


    override fun onStart(){
        super.onStart()
        setUpRecylerView()
        getDataKaryawan()
    }

    private fun setUpRecylerView() {
        dataKaryawanAdapter = DataKaryawanAdapter(arrayListOf(),object : DataKaryawanAdapter.OnAdapterListener{
            override fun onClickViewData(dataKary: KaryawanModel.DataKary) {
                val intent = Intent (this@DataKaryawan, ViewUserActivity::class.java)
                intent.putExtra("Karyawan", dataKary)
                startActivity(intent)
            }
        })
        rvDataKaryawan.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = dataKaryawanAdapter
        }
    }

    private fun getDataKaryawan() {
        api.dataKrywn().enqueue(object :Callback<KaryawanModel>{
            override fun onResponse(call: Call<KaryawanModel>, response: Response<KaryawanModel>) {
                if (response.isSuccessful){
                    showDataKaryawan(response.body()!!)
                }
            }

            override fun onFailure(call: Call<KaryawanModel>, t: Throwable) {
                printLog(t.toString())
            }

        })
    }

    private fun printLog(message: String){
        Log.d(TAG1, message)
    }
    private fun showDataKaryawan(dataKary: KaryawanModel) {
        val hasilData = dataKary.datakar
        dataKaryawanAdapter.setDataKaryawan(hasilData)
    }
}