package id.topan.administrasisistemjaringan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var prefManeger: PrefManeger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefManeger= PrefManeger(this)
        val tvUser : TextView = findViewById(R.id.tv_user)
        tvUser.setText(prefManeger.getSpId())

        val btnMoveSilabus: Button = findViewById(R.id.btn_silabus)
        btnMoveSilabus.setOnClickListener {
            val intent = Intent(this, SilabusActivity::class.java)
            startActivity(intent)
        }

        val btnMoveMateri: Button = findViewById(R.id.btn_materi)
        btnMoveMateri.setOnClickListener {
            val intent = Intent(this, ListMateriActivity::class.java)
            startActivity(intent)
        }

        val btnMoveVideo: Button = findViewById(R.id.btn_video_tutorial)
        btnMoveVideo.setOnClickListener {
            val intent = Intent(this, ListVideoActivity::class.java)
            startActivity(intent)
        }

        val btnMoveSoal: Button = findViewById(R.id.btn_latihan_soal)
        btnMoveSoal.setOnClickListener {
            val intent = Intent(this, ListSoalActivity::class.java)
            startActivity(intent)
        }

        val btnMoveJobsheet: Button = findViewById(R.id.btn_jobsheet)
        btnMoveJobsheet.setOnClickListener {
            val intent = Intent(this, ListJobsheetActivity::class.java)
            startActivity(intent)
        }

        val btnMoveAbout: Button = findViewById(R.id.btn_about)
        btnMoveAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

    }

}