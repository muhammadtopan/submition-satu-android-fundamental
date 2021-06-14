package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PilihEvaluasiActivity extends AppCompatActivity {
    ImageButton ibBack;
    TextView tvToolbar, smt1, smt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_evaluasi);

        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);
        smt1 = findViewById(R.id.tv_smt1);
        smt2 = findViewById(R.id.tv_smt2);

            tvToolbar.setText("Evaluasi");

            smt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String smt = "1";
                    Intent intent = new Intent(getApplicationContext(), EvaluasiActivity.class);
                    intent.putExtra("smt", smt);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                }
            });

            smt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String smt = "2";
                    Intent intent = new Intent(getApplicationContext(), EvaluasiActivity.class);
                    intent.putExtra("smt", smt);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                }
            });

            ibBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

    }

}
