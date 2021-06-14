package com.mot.recycleviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterMhs (private var listMenu: ArrayList<ModelMhs>) : RecyclerView.Adapter<AdapterMhs.GridViewHolder>(){
    inner class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var nama : TextView = itemView.findViewById(R.id.nama)
        var nim : TextView = itemView.findViewById(R.id.nim)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMhs.GridViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_test, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    override fun onBindViewHolder(holder: AdapterMhs.GridViewHolder, position: Int) {
        var model = listMenu[position]
        holder.nama.text = model.nama
        holder.nim.text = model.nim.toString()
    }

}