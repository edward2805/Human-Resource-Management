package com.example.setik.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.setik.Model.KaryawanModel
import com.example.setik.R
import kotlinx.android.synthetic.main.item_karyawan.view.*

class DataKaryawanAdapter
    (val datakar : ArrayList<KaryawanModel.DataKary>,
     val listener: OnAdapterListener
) : RecyclerView.Adapter<DataKaryawanAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate( R.layout.item_karyawan, parent, false )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datakar[position]

        holder.view.tv_nama_karyawan.text = data.nama
        holder.view.tv_no_hp_karyawan.text = data.no_tlp

        holder.view.setOnClickListener{
            listener.onClickViewData( data )
        }
    }

    override fun getItemCount() = datakar.size

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setDataKaryawan(dataKaryawan : List<KaryawanModel.DataKary>){
        datakar.clear()
        datakar.addAll(dataKaryawan)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClickViewData(dataKary: KaryawanModel.DataKary)
    }

}