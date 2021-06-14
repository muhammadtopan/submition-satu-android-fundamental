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
import id.topan.administrasisistemjaringan.adapter.VideoAdapter
import id.topan.administrasisistemjaringan.model.ModelVideo
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class ListVideoActivity : AppCompatActivity() {

    private var video : ArrayList<ModelVideo> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_video)
        AndroidNetworking.initialize(this)

        val rvVideo : RecyclerView = findViewById(R.id.rv_video)
        rvVideo.layoutManager = LinearLayoutManager(this)
        rvVideo.setHasFixedSize(true)

        getVideo(rvVideo)


    }

    private fun getVideo(rvVideo: RecyclerView) {
        AndroidNetworking.get(ApiServer.site_url+"getDataVideo")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    if (response != null) {
                        Log.d("sukses", "code :"+response)
                        if(response.getString("status") == "200"){
                            val data = response.getJSONArray("data")
                            video.clear()
                            for (i in 0 until data.length()){
                                val item = data.getJSONObject(i)
                                video.add(
                                    ModelVideo(
                                    item.getString("id_video"),
                                    item.getString("judul_video"),
                                    item.getString("link")
                                ))
                                val adapterVideo = VideoAdapter(video)
                                rvVideo.adapter = adapterVideo
                                adapterVideo.notifyDataSetChanged()
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