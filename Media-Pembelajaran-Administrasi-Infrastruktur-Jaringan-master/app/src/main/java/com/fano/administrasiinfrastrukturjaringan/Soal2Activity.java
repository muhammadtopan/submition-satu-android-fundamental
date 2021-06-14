package com.fano.administrasiinfrastrukturjaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Soal2Activity extends AppCompatActivity {
    TextView tv;
    ImageView logo;
    ImageButton ibBack;
    TextView tvToolbar;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4, rb5;
    String questions[] = {"1. Nama domain host / server http://www.listi.co.id berlokasi di ?",
            "2. DHCP kepanjangan dari?",
            "3. WWW singkatan dari?",
            "4. Fungsi Switch adalah, kecuali",
            "5. Jenis switch terbagi atas...",
            "6. Sebutkan metode distribusi data",
            "7. Jika nomor IP tidak dikenal dalam jaringan, maka akan muncul pesan?",
            "8. Layanan yang secara otomatis memberikan no ip kepada komputer yang memintanya adalah",
            "9. VTP singakatan dari?",
            "10. Mode switchport adalah",
            "11. Didalam switch ada 2 link yaitu?",
            "12. Tipe trunk ada..",
            "13. fungsi dari \"show vlan brief\" adalah",
            "14. VTY singkatan dari..?",
            "15. Ping Singkatan dari..?",
            "16. #show run berfungsi untuk",
            "17. Ada berapakah Jenis vlan ..?",
            "18. Enable Secret merupakan",
            "19. hostname berfungsi untuk",
            "20. exit berfungsi untuk"
    };

    String answers[] = {"Indonesia", "Dinamyc Host Control Protocol", "World Wide Web", "Mampu mengubah sinyal digital ke analog", "3",
            "Jawaban A dan B benar", "Request time Out", "DHCP", "Virtual Trunking Protocol", "Perintah yang digunakan dalam membuat VLAN",
            "Access link dan trunk link", "4", "untuk menampilkan hasil dari vlan", "Virtual Teletype", "packet internet groper",
            "untuk melihat konfigurasi dasar switch", "5", "pengamanan pada saat user ingin memasuki priviledge mode", "merubah nama switch", "agar user keluar dari mode"
    };
    String opt[] = {"Inggris", "Indonesia", "Singapura", "Cililin", "Jepang",
            "Domain Hosting Circuit Protocol", "Durarara Half Control Protocol", "Dinamyc Host Control Protocol", "Dinamyc  Half Central Protocol", "Domain Host Control Protocol",
            "Wibu Wide World", "Web Web World", "World Wide Web", "World Web Wide", "Word World Wife",
            "Mampu mengubah sinyal digital ke analog", "Memeriksa dengan seksama setiap paket data yang diterima", "Menemukan tujuan dan sumber paket yang melaluinya", "Memiliki kemampuan untuk memforward setiap paket data dengan tepat", "Jawaban A dan C Benar",
            "2", "3", "5", "Jawaban A dan B benar", "Tidak ada jawaban yang benar",
            "Jaringan terpusat", "Jaringan teridistibusi", "Jaringan nirkabel", "Jawaban A dan B benar", "Jaringan berkabel",
            "Time to Leave", "Time for Love", "Time With you", "Request Time Output", "Request time Out",
            "TCP", "IP", "Server", "Statis", "DHCP",
            "Virtual Transfer Pop", "Virtual Trunking Protocol", "Virtual To Pull", "Virtual To Protocol", "Virtual time Protocol",
            "Perintah yang digunakan dalam membuat VLAN", "Perintah yang digunakan untuk keluar", "Perintah yang digunakan untuk trunking", "Jawaban a dan b benar", "Tidak da jawaban yang benar",
            "Access link dan trunk link", "Access link dan vlan link", "Vlan link dan trunk link", "Switch link dan vlan link", "Vlan link dan router link",
            "4", "3", "5", "6", "7",
            "untuk menampilkan option", "untuk memberikan jawaban", "untuk menampilkan hasil dari vlan", "untuk membackup konfigurasi", "agar konfigurasi mudah",
            "Virtual Teletype", "Virtual To YOU", "Virtual Time Yours", "Vlan To Young", "Virtual Time Young",
            "pure interfaces group", "packet internet groper", "packet interface groper", "pure internet groper", "packet international group",
            "untuk melihat hasil jalan", "untuk menjalankan hasil konfigurasi", "untuk mengetahui konfigurasi berhasil atau tidak", "untuk melihat konfigurasi dasar switch", "untuk mengakhiri konfigurasi",
            "2", "4", "5", "8", "9",
            "pengamanan pada saat user ingin memasuki priviledge mode", "untuk mengaktifkan rahasia", "untuk pengebalan password", "untuk memudahkan konfigurasi", "untuk mode mudah",
            "nama rumah", "merubah nama switch", "merubah nama jalan", "untuk kasih kode", "tidak ada jawaban yang benar",
            "agar user keluar dari mode", "agar user memasuki area konfigurasi", "jawaban a dan b benar", "agar user langsung konfigurasi switch dengan mudah", "tidak ada jawaban yang benar"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal2);

        tvToolbar = findViewById(R.id.tv_toolbar);
        ibBack = findViewById(R.id.ib_back);
        final TextView textView=(TextView)findViewById(R.id.DispName);
        submitbutton=(Button)findViewById(R.id.button3);
        tv=(TextView) findViewById(R.id.tvque);
        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        rb5=(RadioButton)findViewById(R.id.radioButton5);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        rb5.setText(opt[4]);
        tvToolbar.setText("Evaluasi Semester II");


        logo = (ImageView) findViewById(R.id.smk);
        logo.setAlpha(32);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

            Intent intent = getIntent();
            String name = intent.getStringExtra("myname");
            String myclass = intent.getStringExtra("myclass");

            if (name.trim().equals("")) {
                textView.setText("Guest");
            } else {
                textView.setText("Nama : " + name + "\nKelas  : " + myclass);
            }

            submitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (radio_g.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "Mohon Pilih Satu Jawaban", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                    String ansText = uans.getText().toString();

                    if (ansText.equals(answers[flag])) {
                        correct++;
                        Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
                    } else {
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
                    }

                    flag++;


                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag * 5]);
                        rb2.setText(opt[flag * 5 + 1]);
                        rb3.setText(opt[flag * 5 + 2]);
                        rb4.setText(opt[flag * 5 + 3]);
                        rb5.setText(opt[flag * 5 + 4]);
                    } else {
                        marks = correct;
                        String smt = "2";
                        String nama = textView.getText().toString();
                        Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                        in.putExtra("smt", smt);
                        in.putExtra("nama", nama);
                        startActivity(in);

                    }
                    radio_g.clearCheck();
                }
            });

    }

    @Override
    public void onRestart(){
        super.onRestart();

            finish();
            startActivity(getIntent());
            flag=0;
            marks=0;
            correct=0;
            wrong=0;


    }
}
