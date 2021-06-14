package id.topan.administrasisistemjaringan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import id.topan.administrasisistemjaringan.MateriPageActivity
import id.topan.administrasisistemjaringan.R
import id.topan.administrasisistemjaringan.SoalPageActivity
import id.topan.administrasisistemjaringan.model.ModelMateri

class SoalAdapter(val listJudulSoal: List<ModelMateri>) : RecyclerView.Adapter<SoalAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_materi, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listJudulSoal.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val model = listJudulSoal.get(position)
        holder.btnSoal.setText(model.materi)

        holder.btnSoal.setOnClickListener {
            val contex: Context = it!!.context
            val intent = Intent(contex, SoalPageActivity::class.java)
            intent.putExtra("ID", model.id)

            contex.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnSoal: Button =itemView.findViewById(R.id.btn_item_judul_materi)

    }

}