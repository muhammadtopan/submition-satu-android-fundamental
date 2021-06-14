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
import id.topan.administrasisistemjaringan.adapter.JobsheetAdapter
import id.topan.administrasisistemjaringan.model.ModelJobsheet
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class ListJobsheetActivity : AppCompatActivity() {

    private var jobsheet : ArrayList<ModelJobsheet> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_jobsheet)
        AndroidNetworking.initialize(this)

        val rvJobsheet : RecyclerView = findViewById(R.id.rv_jobsheet)
        rvJobsheet.layoutManager = LinearLayoutManager(this)
        rvJobsheet.setHasFixedSize(true)

        getJobsheet(rvJobsheet)


    }

    private fun getJobsheet(rvJobsheet: RecyclerView) {
        AndroidNetworking.get(ApiServer.site_url+"getDataJobsheet")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    if (response != null) {
                        Log.d("sukses", "code :"+response)
                        if(response.getString("status") == "200"){
                            val data = response.getJSONArray("data")
                            for (i in 0 until data.length()){
                                val item = data.getJSONObject(i)
                                jobsheet.add(
                                    ModelJobsheet(
                                    item.getString("id_jobsheet"),
                                    item.getString("judul_jobsheet"),
                                    item.getString("file")
                                )
                                )
                                val adapterjobsheet = JobsheetAdapter(jobsheet)
                                rvJobsheet.adapter = adapterjobsheet
                                adapterjobsheet.notifyDataSetChanged()
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