package id.topan.administrasisistemjaringan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import id.topan.administrasisistemjaringan.model.ModelSoal
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class SoalPageActivity : AppCompatActivity() {

    private var dataLengkapSoal : ArrayList<ModelSoal> = arrayListOf()

//    companion object{
//        const val  EXTRA_ID = "id"
//    }

    var soalItem = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal_page)
        val pertanyaan: TextView = findViewById(R.id.tv_pertanyaan)
        val tv_a: TextView = findViewById(R.id.tv_a)
        val tv_b: TextView = findViewById(R.id.tv_b)
        val tv_c: TextView = findViewById(R.id.tv_c)
        val tv_d: TextView = findViewById(R.id.tv_d)
        val tv_e: TextView = findViewById(R.id.tv_e)
        val id = intent.getStringExtra(MateriPageActivity.EXTRA_ID)
        val next : Button = findViewById(R.id.btn_next_soal)
        next.setOnClickListener {
            soalItem= soalItem + 1

            getDataMateri(id, pertanyaan, tv_a, tv_b, tv_c, tv_d, tv_e)
        }

        getDataMateri(id, pertanyaan, tv_a, tv_b, tv_c, tv_d, tv_e)

    }


    private fun getDataMateri(id: String?, pertanyaan: TextView, tvA: TextView, tvB: TextView, tvC: TextView, tvD: TextView, tvE: TextView) {
        AndroidNetworking.post(ApiServer.site_url+"getDataSoal")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    if (response != null) {
                        Log.d("sukses", "code :" + response)
                        if (response.getString("status") == "200") {
                            val data = response.getJSONArray("data")
                                val item = data.getJSONObject(soalItem)
                            pertanyaan.setText(item.getString("soal"))
                            pertanyaan.setText(item.getString("soal"))
                            tvA.setText(item.getString("pil_a"))
                            tvB.setText(item.getString("pil_b"))
                            tvC.setText(item.getString("pil_c"))
                            tvD.setText(item.getString("pil_d"))
                            tvE.setText(item.getString("pil_e"))

                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.d("eror", "Eror"+anError)
                }
            })
    }
}