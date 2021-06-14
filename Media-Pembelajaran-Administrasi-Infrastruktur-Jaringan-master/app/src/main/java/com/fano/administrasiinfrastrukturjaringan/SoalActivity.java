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

public class SoalActivity extends AppCompatActivity {
    TextView tv;
    ImageView logo;
    ImageButton ibBack;
    TextView tvToolbar;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4, rb5;
    String questions[] = {"1. Cara kerja switch, yaitu dengan cara ... pada suatu port.",
            "2. \"Switch(config-if)#switchport trunk allowed VLAN add 10\" Perintah tersebut merupakan perintah untuk ...",
            "3. Guna menampilkan informasi mengenai suatu VLAN tertentu, berdasarkan nomor ID dengan menggunakan perintah...",
            "4. Untuk mendapatkan akses jaringan maka dilakukan pengontrolan daerah klien. Hal ini adalah salah satu fungsi dari...",
            "5. Perintah untuk menampilkan daftar VLAN yang aktif dan port yang terkait dengan masing-masing, yaitu ...",
            "6. Perhatikan perintah VLAN berikut!\n" +
                    "(1) Show VLAN\n" +
                    "(2) Show VLAN brief\n" +
                    "(3) Show VLAN id id number\n" +
                    "(4) Show VLAN name vlan name\n" +
                    "(5) Show VLAN address id\n" +
                    "Yang merupakan perintah menampilkan informasi mengenai suatu VLAN tertentu berdasarkan nomor ID adalah...",
            "7. VLAN ID adalah ...",
            "8. Berikut yang membantu manajemen VLAN hanya dapat bekerja pada normal  range VLAN, dan menyimpannya dalam file database VLAN adalah...",
            "9. Port switch yang dikonfigurasikan secara manual pada setiap portnya disebut...",
            "10. Manajemen lalu lintas data yang terdapat pada suatu jaringan komputer merupakan fungsi dari ...",
            "11. Vlan bertujuan untuk…",
            "12. Nama lain perangkat jaringan komputer adalah…",
            "13. Kinerja switch menjadi cepat dan handal karena langsung mengirim data ke…",
            "14. Trunk link tidak dibuat untuk satu VLAN, beberapa, atau semua VLAN aktif dapat dilewati antar-switch dengan mengguunakan satu trunk link karna bertujuan untuk?",
            "15. Salah satu cara mengecek trunking dengan cara ....",
            "16. Sebuah port switch yang telah di konfigurasi dengan sebuah VLAN tunggal disebut sebagai....",
            "17. Agar komputer berkomunikasi pada VLAN yang sama setiap komputer harus memiliki sebuah ....",
            "18. Pernyataan diatas merupakan karakteristik dari ....",
            "19. Switch mengirimkan data mengikuti MAC address yang terdapat pada NIC sehingga switch mengetahui alamat tujuanya, merupakan fungsi dari ....",
            "20. Merupakan sekelompok perangkat pada satu LAN atau lebih yang dikonfigurasikan (menggunakanperangkat lunak pengelolaan) sehingga dapat berkomunikasi seperti halnya bila perangkat tersebut terhubung ke jalur yang sama, padahal sebenarnya perangkat tersebut berada pada sejumlah segmen LAN yang berbeda, merupakan pengertian dari ...."};

    String answers[] = {"menghubungkan paket data", "allowed VLAN", "Show VLAN brief", "extended access control list", "Show VLAN id number",
    "Show VLAN brief", "nomor identitas VLAN", "VTP", "statis VLAN", "switch",
    "Memperlancar lalu lintas data", "Network device", "Tujuan", "Adalah mungkin untuk menghubungkan dua switch dengan link fisik terpisah untuk setiap VLAN", "PING",
            "Access port", "Alamat IP dan Subnetmask", "Switch", "Switch", "VLAN"
    };
    String opt[] = {"mengirim paket data", "menerima paket data", "menghubungkan paket data", "merusak", "menghubungkan",
    "membatalkan trunk antara switch 1 dan switch", "menghapus konfigurasi switch 1", "membuat konfigurasi switch 2", "menghapus konfigurasi switch 2", "allowed VLAN",
    "Show VLAN", "Show VLAN brief", "Show VLAN id_number", "Show VLAN name VLAN name", "Show VLAN exit",
            "standart access list", "access control list", "extended access control list", "managed switch", "switch",
            "Show VLAN", "Show VLAN brief", "Show VLAN id number", "Show VLAN name VLAN_name", "Show VLAN exit",
            "Show VLAN", "Show VLAN brief", "Show VLAN id id number", "Show VLAN name vlan_name", "Show VLAN address id",
            "nomor identitas jaringan", "nomor identitas VLAN", "nomor identitas IP", "nomor identitas network", "nomor identitas komputer",
            "FTP", "LAN", "VTP", "USB", "FDD",
            "dinamis VLAN", "VLAN membership", "voice VLAN", "inter VLAN routing", "statis VLAN",
            "router", "antena grid", "HUB", "switch", "access point",
            "Memperlancar Proses pengubahan data", "Memperbaiki lalu lintas data", "Mengurangi besarnya data", "Memperlancar lalu lintas data", "Mengubah data",
            "Network", "Networking", "Network device", "Device", "Hub",
            "Luar", "Tujuan", "Monitor", "Media transmisi", "Folder",
            "Adalah mungkin untuk menghubungkan dua switch dengan link fisik terpisah untuk setiap VLAN", "Adalah untuk menghubungkan tiga switch link bersamaan", "Adalah untuk menghubungkan link dengan vlan yang belum menyatu", "Untuk menghubungkan jaringan", "Untuk menyatukan ipLancars dari vlan",
            "Pong", "PING", "Pdkt", "Spam Like", "Follback",
            "Access port", "Ip", "Seven segment", "VLAN", "Trunking",
            "Alamat IP dan Subnetmask", "Alamat email", "Alamat Ip dan Router", "Alamat email dan Subnetmask", "Tidak ada jawaban yang benar",
            "Trunking", "Bandwith", "VLAN", "Switch", "Router",
            "Router", "Switch", "VLAN", "automaticly dinamic", "Trunking",
            "LAN", "VLAN", "WAN", "MAN", "Http"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

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
        tvToolbar.setText("Evaluasi Semester I");


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
                        String smt = "1";
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
