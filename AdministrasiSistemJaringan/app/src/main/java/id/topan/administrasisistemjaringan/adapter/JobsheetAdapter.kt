package id.topan.administrasisistemjaringan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import id.topan.administrasisistemjaringan.JobsheetPageActivity
import id.topan.administrasisistemjaringan.R
import id.topan.administrasisistemjaringan.model.ModelJobsheet

class JobsheetAdapter(val listJudulJobsheet: ArrayList<ModelJobsheet>) : RecyclerView.Adapter<JobsheetAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_materi, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listJudulJobsheet.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val model = listJudulJobsheet.get(position)
        holder.btnJobsheet.setText(model.judul_jobsheet)

        holder.btnJobsheet.setOnClickListener {
            val contex: Context = it!!.context
            val intent = Intent(contex, JobsheetPageActivity::class.java)
            intent.putExtra("file", model.file)
            contex.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnJobsheet: Button =itemView.findViewById(R.id.btn_item_judul_materi)

    }

}