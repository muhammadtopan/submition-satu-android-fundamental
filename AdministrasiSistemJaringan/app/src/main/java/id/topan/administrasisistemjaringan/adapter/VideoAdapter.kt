package id.topan.administrasisistemjaringan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import id.topan.administrasisistemjaringan.R
import id.topan.administrasisistemjaringan.VideoPageActivity
import id.topan.administrasisistemjaringan.model.ModelVideo

class VideoAdapter(val listJudulMateri: List<ModelVideo>) : RecyclerView.Adapter<VideoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_materi, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listJudulMateri.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val model = listJudulMateri.get(position)
        holder.btnMateri.setText(model.judul_video)

        holder.btnMateri.setOnClickListener {
            val contex: Context = it!!.context
            val intent = Intent(contex, VideoPageActivity::class.java)
            intent.putExtra("link", model.link)
            contex.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnMateri: Button =itemView.findViewById(R.id.btn_item_judul_materi)

    }

}