package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EvaluasiActivity extends AppCompatActivity {
    ImageButton ibBack;
    TextView tvToolbar;
    EditText nama, kelas;
    Button btnMulai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluasi);

        nama = findViewById(R.id.editName);
        kelas = findViewById(R.id.editKelas);
        btnMulai = findViewById(R.id.button2);
        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);
        tvToolbar.setText("Evaluasi");

        final Intent intent = getIntent();
        final String smtEvaluasi = intent.getStringExtra("smt");

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (smtEvaluasi.equalsIgnoreCase("1")) {
                    String name = nama.getText().toString();
                    String kelasSiswa = kelas.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), SoalActivity.class);
                    intent.putExtra("myname", name);
                    intent.putExtra("myclass", kelasSiswa);
                    startActivity(intent);

                } else if (smtEvaluasi.equalsIgnoreCase("2")) {
                    String name = nama.getText().toString();
                    String kelasSiswa = kelas.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), Soal2Activity.class);
                    intent.putExtra("myname", name);
                    intent.putExtra("myclass", kelasSiswa);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onRestart(){
        super.onRestart();
        finish();

    }
}
