package id.topan.administrasisistemjaringan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MateriPageActivity : AppCompatActivity() {


    companion object{
        const val  EXTRA_ID = "id"
    }

    var pdf = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_page)

        val web: WebView = findViewById(R.id.wv_materi)

//        val id = intent.getStringExtra(EXTRA_ID)
        pdf = intent.getStringExtra("file") as Nothing?

//        getDataMateri(id)


//        web.requestFocus()

        val myPdfUrl = "$pdf"
//        web.settings.javaScriptEnabled = true
        val url = "https://docs.google.com/viewer?embedded=true&url=$myPdfUrl"
        web.loadUrl(url)
    }

//    private fun getDataMateri(id: String?) {
//        AndroidNetworking.post(ApiServer.site_url+"getIdMateri")
//            .addBodyParameter("id", id)
//            .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(object : JSONObjectRequestListener{
//                    override fun onResponse(respon: JSONObject?) {
//                        if (respon != null) {
//                            Log.d("sukses", "code :" + respon)
//                            if (respon.getString("status") == "200") {
//                                val data = respon.getJSONArray("data")
//                                val item = data.getJSONObject(0)
//                                dataLengkapMateri.add(
//                                    Model(
//                                        item.getString("id_materi"),
//                                        item.getString("judul_materi"),
//                                        item.getString("deskripsi"),
//                                        item.getString("file")
//                                    )
//                                )
//                            }
//                        }
//                    }
//
//                    override fun onError(anError: ANError?) {
//                        Log.d("eror", "Eror"+anError)
//                    }
//                })
//    }
}

















