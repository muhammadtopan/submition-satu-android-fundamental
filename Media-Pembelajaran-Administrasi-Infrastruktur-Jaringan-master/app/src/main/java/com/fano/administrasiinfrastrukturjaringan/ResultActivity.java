package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    ImageButton ibBack;
    TextView tvToolbar;
    Button btnRestart, btnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);

        tvToolbar.setText("Evaluasi");
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        final String smtEvaluasi = intent.getStringExtra("smt");
        String namaSiswa =  intent.getStringExtra("nama");

        if (smtEvaluasi.equalsIgnoreCase("1")) {
            StringBuffer sb = new StringBuffer();
            sb.append(SoalActivity.correct);
            StringBuffer sb2 = new StringBuffer();
            sb2.append(SoalActivity.wrong);

            int skor = Integer.valueOf(SoalActivity.correct) * 5;
            tv.setText(sb);
            tv2.setText(sb2);
            tv3.setText(String.valueOf(skor));

        }
        else if (smtEvaluasi.equalsIgnoreCase("2")){
            StringBuffer sb = new StringBuffer();
            sb.append(Soal2Activity.correct);
            StringBuffer sb2 = new StringBuffer();
            sb2.append(Soal2Activity.wrong);

            int skor = Integer.valueOf(Soal2Activity.correct) * 5;
            tv.setText(sb);
            tv2.setText(sb2);
            tv3.setText(String.valueOf(skor));
        }


        SoalActivity.correct=0;
        SoalActivity.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRestart(){
        super.onRestart();

        finish();

    }
}
