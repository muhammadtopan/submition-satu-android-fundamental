package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.fano.administrasiinfrastrukturjaringan.model.DataKd;

public class IsiMateriActivity extends AppCompatActivity {
    PDFView pdfView;
    ImageButton ibBack;
    TextView tvToolbar, tvNext;
    String kd;
    public static final String EXTRA_KD= "extra_kd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        tvToolbar = findViewById(R.id.tv_toolbar);
        tvNext = findViewById(R.id.tv_next);
        ibBack = findViewById(R.id.ib_back);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        final DataKd selectedKd = getIntent().getParcelableExtra(EXTRA_KD);

        if (selectedKd != null) {
            if (selectedKd.getKd().equalsIgnoreCase("K.D 3.9")){
                tvNext.setVisibility(View.GONE);
                pdfView.fromAsset(selectedKd.getPdfKd()).load();
                tvToolbar.setText(selectedKd.getKd());
            }else {
                kd = selectedKd.getKd();
                tvNext.setVisibility(View.VISIBLE);
                pdfView.fromAsset(selectedKd.getPdfKd()).load();
                tvToolbar.setText(selectedKd.getKd());
            }
        }

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kd.equalsIgnoreCase("K.D 3.1")){
                    pdfView.fromAsset("kd32.pdf").load();
                    tvToolbar.setText("K.D 3.2");
                    kd = "K.D 3.2";
                }else if (kd.equalsIgnoreCase("K.D 3.2")){
                    pdfView.fromAsset("kd33.pdf").load();
                    tvToolbar.setText("K.D 3.3");
                    kd = "K.D 3.3";
                }else if (kd.equalsIgnoreCase("K.D 3.3")){
                    pdfView.fromAsset("kd34.pdf").load();
                    tvToolbar.setText("K.D 3.4");
                    kd = "K.D 3.4";
                }else if (kd.equalsIgnoreCase("K.D 3.4")){
                    pdfView.fromAsset("kd35.pdf").load();
                    tvToolbar.setText("K.D 3.5");
                    kd = "K.D 3.5";
                }else if (kd.equalsIgnoreCase("K.D 3.5")){
                    pdfView.fromAsset("kd36.pdf").load();
                    tvToolbar.setText("K.D 3.6");
                    kd = "K.D 3.6";
                }else if (kd.equalsIgnoreCase("K.D 3.6")){
                    pdfView.fromAsset("kd37.pdf").load();
                    tvToolbar.setText("K.D 3.7");
                    kd = "K.D 3.7";
                }else if (kd.equalsIgnoreCase("K.D 3.7")){
                    pdfView.fromAsset("kd38.pdf").load();
                    tvToolbar.setText("K.D 3.8");
                    kd = "K.D 3.8";
                }else if (kd.equalsIgnoreCase("K.D 3.8")){
                    pdfView.fromAsset("kd39.pdf").load();
                    tvToolbar.setText("K.D 3.9");
                    tvNext.setVisibility(View.GONE);
                }
            }
        });
    }
}
