package id.topan.administrasisistemjaringan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import id.topan.administrasisistemjaringan.model.Model
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class JobsheetPageActivity : AppCompatActivity() {

    private var dataLengkapJobsheet : ArrayList<Model> = arrayListOf()

    companion object{
        const val  EXTRA_ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobsheet_page)

        val web: WebView = findViewById(R.id.wv_jobsheet)

        val id = intent.getStringExtra(EXTRA_ID)

        getDataMateri(id)


        web.requestFocus()

        val myPdfUrl = "pdf.pdf"
        web.settings.javaScriptEnabled = true
        val url = "https://docs.google.com/viewer?embedded=true&url=jualtbs.com/$myPdfUrl"
        web.loadUrl(url)
    }

    private fun getDataMateri(id: String?) {
        AndroidNetworking.post(ApiServer.site_url+"getIdJobsheet")
            .addBodyParameter("id", id)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    if (response != null) {
                        Log.d("sukses", "code :" + response)
                        if (response.getString("status") == "200") {
                            val data = response.getJSONArray("data")
                            val item = data.getJSONObject(0)
                            dataLengkapJobsheet.add(
                                Model(
                                    item.getString("id_jobsheet"),
                                    item.getString("judul_jobsheet"),
                                    item.getString("deskripsi"),
                                    item.getString("file")
                                )
                            )
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.d("eror", "Eror"+anError)
                }
            })
    }
}