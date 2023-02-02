package com.example.setik.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.setik.Model.ReportModel
import com.example.setik.R
import kotlinx.android.synthetic.main.adapter_report.view.*

class ReportAdapter(
    val dataTugas: ArrayList<ReportModel.Data>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<ReportAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_report, parent, false)
    )

    override fun onBindViewHolder(holder: ReportAdapter.ViewHolder, position: Int) {
        val data = dataTugas[position]


        holder.view.tv_site_name.text = "Site Name   : "+ data.site_name
        holder.view.tv_ttnumber.text = "TT Number       : "+data.tt_number
        holder.view.tv_status.text = "Status                : "+ data.status

        holder.view.setOnClickListener{
            listener.onClickView( data )
        }
        holder.imagedelete.setOnClickListener{
            listener.onDelete( data )
        }
    }

    override fun getItemCount()= dataTugas.size

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val imagedelete = view.findViewById<ImageView>(R.id.ic_delete)
    }

    fun setData(data : List<ReportModel.Data>){
        dataTugas.clear()
        dataTugas.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClickView( data: ReportModel.Data )
        fun onDelete( data: ReportModel.Data )
    }
}