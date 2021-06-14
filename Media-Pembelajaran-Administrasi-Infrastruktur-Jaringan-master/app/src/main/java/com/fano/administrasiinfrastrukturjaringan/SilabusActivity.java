package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fano.administrasiinfrastrukturjaringan.model.DataKd;
import com.github.barteksc.pdfviewer.PDFView;

public class SilabusActivity extends AppCompatActivity {
    PDFView pdfView;
    ImageButton ibBack;
    TextView tvToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabus);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        pdfView.fromAsset("silabus.pdf").load();
        tvToolbar.setText("Silabus");

    }
}
