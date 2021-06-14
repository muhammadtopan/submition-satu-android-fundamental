package id.topan.submitionsatufundamental

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var items: MutableList<ClipData.Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()



    }

    private fun initData() {
        TODO("Not yet implemented")
    }
}