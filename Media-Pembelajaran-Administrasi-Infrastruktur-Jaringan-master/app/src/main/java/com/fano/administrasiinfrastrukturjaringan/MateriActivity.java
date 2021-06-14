package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fano.administrasiinfrastrukturjaringan.adapter.KdAdapter;
import com.github.barteksc.pdfviewer.PDFView;
import com.fano.administrasiinfrastrukturjaringan.model.DataKd;

import java.util.ArrayList;

public class MateriActivity extends AppCompatActivity {
    private RecyclerView rvKd;
    private ArrayList<DataKd> listKd = new ArrayList<>();
    PDFView pdfView;
    ImageButton ibBack;
    TextView tvToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        rvKd = findViewById(R.id.recyclerKd);
        rvKd.setHasFixedSize(true);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);
        tvToolbar.setText("Materi");

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        listKd.addAll(getListKd());
        showRecyclerList();
    }

    public ArrayList<DataKd> getListKd() {
        String[] dataKd = getResources().getStringArray(R.array.kd);
        String[] dataJudul = getResources().getStringArray(R.array.judulKd);
        String[] dataPdf = getResources().getStringArray(R.array.pdfKd);
        TypedArray dataLogo = getResources().obtainTypedArray(R.array.gambarKd);
        ArrayList<DataKd> listKd = new ArrayList<>();
        for (int i = 0; i < dataKd.length; i++) {
            DataKd data = new DataKd();
            data.setKd(dataKd[i]);
            data.setJudulKd(dataJudul[i]);
            data.setPdfKd(dataPdf[i]);
            data.setGambarKd(dataLogo.getResourceId(i, -1));
            listKd.add(data);
        }
        return listKd;
    }

    private void showRecyclerList(){
        rvKd.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        KdAdapter listKdAdapter = new KdAdapter(listKd, getApplicationContext());
        rvKd.setAdapter(listKdAdapter);
    }
}
