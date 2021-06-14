package id.topan.administrasisistemjaringan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import id.topan.administrasisistemjaringan.adapter.MateriAdapter
import id.topan.administrasisistemjaringan.model.ModelMateri
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class ListMateriActivity : AppCompatActivity() {

    private var materi : ArrayList<ModelMateri> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_materi)
        AndroidNetworking.initialize(this)

        val rvMateri : RecyclerView = findViewById(R.id.rv_open_materi)
        rvMateri.layoutManager = LinearLayoutManager(this)
        rvMateri.setHasFixedSize(true)

        getMateri(rvMateri)


    }

    private fun getMateri(rvMateri: RecyclerView) {
        AndroidNetworking.get(ApiServer.site_url+"getDataMateri")
            .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        if (response != null) {
                            Log.d("sukses", "code :"+response)
                            if(response.getString("status") == "200"){
                                val data = response.getJSONArray("data")
                                for (i in 0 until data.length()){
                                    val item = data.getJSONObject(i)
                                    materi.add(ModelMateri(
                                            item.getString("id_materi"),
                                            item.getString("judul_materi"),
                                            item.getString("file")
                                    ))
                                    val adapterMateri = MateriAdapter(materi)
                                    rvMateri.adapter = adapterMateri
                                    adapterMateri.notifyDataSetChanged()

                                }
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Log.d("eror", "eror : "+anError)
                    }
                })
    }
}