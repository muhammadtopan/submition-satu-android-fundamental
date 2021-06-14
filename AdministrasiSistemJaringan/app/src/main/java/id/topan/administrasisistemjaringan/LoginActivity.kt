package id.topan.administrasisistemjaringan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import id.topan.administrasisistemjaringan.network.ApiServer
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: PrefManeger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username : EditText = findViewById(R.id.et_username)
        val password : EditText = findViewById(R.id.et_password)


        sharedPreferences= PrefManeger(this)

        if (sharedPreferences.getSpSudahLogin() == true) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            getDataUser(username, password)
        }


    }

    private fun getDataUser(username: EditText, password: EditText) {
        AndroidNetworking.post(ApiServer.site_url+"loginUser")
            .addBodyParameter("username", username.text.toString())
            .addBodyParameter("password", password.text.toString())
            .setPriority(Priority.MEDIUM)
            .setTag("login")
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    if (response != null)
                    {
                        Log.d("sukses","code : "+ response+ username+ password)
                        if (response.getString("status") == "200"){
                            val user = response.getJSONObject("user")
                            sharedPreferences.saveSPBoolean(sharedPreferences.SP_SUDAH_LOGIN, true)
                            sharedPreferences.saveSPString(sharedPreferences.SP_ID, user.getString("id_user"))
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.d("eror", "Eror : "+anError)
                }
            })
    }

}
