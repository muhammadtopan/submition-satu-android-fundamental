package id.topan.submitionsatufundamental

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val item: List<Users>, private val listener: (Users) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder>(){

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_users, parent, false)
//        return ListViewHolder(view)
        ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row_users, parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

    inner class ListViewHolder(containView: View) : RecyclerView.ViewHolder(containView) {
        fun bindItem(users: Users, listener: (Users) -> Unit) {
        }

    }

}










