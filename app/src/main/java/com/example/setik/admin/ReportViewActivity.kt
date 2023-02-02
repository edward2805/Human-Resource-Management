package com.example.setik.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.setik.Adapter.ReportAdapter
import com.example.setik.Model.ReportModel
import com.example.setik.R
import com.example.setik.Retrofit.RetrofitReport
import kotlinx.android.synthetic.main.activity_report_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportViewActivity : AppCompatActivity() {

    private var binding : ReportViewActivity? = null

    private val TAG : String = "ReportViewActivity"

    private val api by lazy { RetrofitReport().endpoint }
    lateinit var reportAdapter: ReportAdapter
    private lateinit var listData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_view)

        val kembali = findViewById<ImageView>(R.id.kembali_Report_VIEW)
        kembali.setOnClickListener {
            Intent(this@ReportViewActivity , MainActivityAdmin::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        setupRecylerview()
        getData()
    }

    private fun setupRecylerview(){
        reportAdapter = ReportAdapter(arrayListOf(),object :ReportAdapter.OnAdapterListener{
            override fun onClickView(data: ReportModel.Data) {
                startActivity(Intent(this@ReportViewActivity, DetailTugasAdminActivity::class.java)
                    .putExtra("data", data))
            }
            override fun onDelete(data: ReportModel.Data) {
                api.delete(data.id_tugas!!)
                    .enqueue(object : Callback<ReportModel>{
                        override fun onResponse(
                            call: Call<ReportModel>,
                            response: Response<ReportModel>
                        ) {
                            if (response.isSuccessful){
                                response.body()
                                Toast.makeText(
                                    applicationContext,
                                     "data berhasil di hapus",
                                    Toast.LENGTH_SHORT
                                ).show()
                                getData()
                            }
                        }
                        override fun onFailure(call: Call<ReportModel>, t: Throwable) {
                        }
                    })
            }
        })
        rvReport.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = reportAdapter
        }
    }


    private fun getData(){
        api.data()
            .enqueue(object : Callback<ReportModel>{
                override fun onResponse(call: Call<ReportModel>,
                                        response: Response<ReportModel>) {
                    if (response.isSuccessful){
                        showData(response.body()!!)
                    }
                }
                override fun onFailure(call: Call<ReportModel>, t: Throwable) {
                        printLog(t.toString())
                }
            })
    }

    private fun printLog(message: String){
        Log.d(TAG, message)
    }
    private fun showData(data: ReportModel){
        val DataTugas = data.datatugas
        reportAdapter.setData( DataTugas )
    }
}