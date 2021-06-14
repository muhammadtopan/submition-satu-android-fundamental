package com.mot.recycleviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mhs : ArrayList<ModelMhs> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvkot.setHasFixedSize(true)
        rvkot.layoutManager = LinearLayoutManager ( this)

        for (i in 0 until 5){
            mhs.add(
                ModelMhs(
                    1,
                    "Muuhammad Topan",
                    1710953046
                )
            )
        }
        val adapterMhs = AdapterMhs(mhs)
        rvkot.setAdapter(adapterMhs)
        adapterMhs.notifyDataSetChanged()

    }
}