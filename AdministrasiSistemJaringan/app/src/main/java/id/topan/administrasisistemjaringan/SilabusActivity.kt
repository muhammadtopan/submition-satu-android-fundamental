package id.topan.administrasisistemjaringan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SilabusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_silabus)

        val web: WebView = findViewById(R.id.webSilabus)

        web.requestFocus()
        web.settings.javaScriptEnabled = true
        val myPdfUrl = "pdf.pdf"
        val url = "https://docs.google.com/viewer?embedded=true&url=jualtbs.com/$myPdfUrl"
        web.loadUrl(url)
    }
}