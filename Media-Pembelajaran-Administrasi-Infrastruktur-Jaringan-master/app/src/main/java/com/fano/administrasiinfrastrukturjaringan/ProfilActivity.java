package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    ImageButton ibBack;
    TextView tvToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
