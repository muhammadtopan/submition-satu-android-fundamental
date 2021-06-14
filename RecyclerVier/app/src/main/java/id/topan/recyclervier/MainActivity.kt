package id.topan.recyclervier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list = ArrayList<Users>()
    val  listUsers = arrayOf(
        "Google",
        "Apple",
        "Microsoft",
        "Asus",
        "Zenpone",
        "Acer"
    )
//    val  tanggal = arrayOf(
//        "10 Septermber 2020",
//        "1 Januari 2020",
//        "10 November 2020",
//        "19 Juni 2020",
//        "28 Maret 2020",
//        "7 Mei 2020"
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        for (i in 0 until listUsers.size){
            list.add(Users(listUsers.get(i)))
            if (listUsers.size - 1 == i){
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()

                mRecyclerView.adapter = adapter
            }
        }
    }

}