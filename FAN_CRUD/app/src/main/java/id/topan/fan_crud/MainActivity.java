    package id.topan.fan_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; //untuk melihat log
    private EditText etNim, etNama, etJurusan; //pembuatan variabel edittext
    private Button btnTambah, btnLihat; //pembuatan variabel button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: inisialisasi"); //untuk log pada oncreate

        etNim  = findViewById(R.id.editTextMainNim); //inisialisasi value etNim
        etNama = findViewById(R.id.editTextMainNama); //inisialisasi value etNama
        etJurusan = findViewById(R.id.editTextMainJurusan); //inisialisasi value etKelas
        btnTambah = findViewById(R.id.buttonMainTambah); //inisialisasi value btnTambah
        btnLihat = findViewById(R.id.buttonMainLihat); //inisialisasi value btnLihat

        AndroidNetworking.initialize(this); //inisialisasi library FAN
        aksiButton();//memanggil fungsi aksiButton()
    }

    public void aksiButton(){

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String nim = etNim.getText().toString(); //mengambil Value etNim menjadi string
                String nama = etNama.getText().toString(); //mengambil Value etNim menjadi string
                String kelas = etJurusan.getText().toString(); //mengambil Value etNim menjadi string
                if (nim.equals("")||nama.equals("")||kelas.equals("")){
                    Toast.makeText(getApplicationContext(),"Masih ado yang alun ang isi tua!!" , Toast.LENGTH_SHORT).show();
                    //memunculkan toast saat form masih ada yang kosong
                } else {
                    tambahData(nim,nama,kelas); //memanggil fungsi tambahData()

                    etNim.setText(""); //mengosongkan form setelah data berhasil ditambahkan
                    etNama.setText(""); //mengosongkan form setelah data berhasil ditambahkan
                    etJurusan.setText(""); //mengosongkan form setelah data berhasil ditambahkan
                }
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //untuk pindah keActivity lain saat buttonlihat dipencet
                Intent intent = new Intent(MainActivity.this, activity_read_all.class);
                intent.putExtra("NIM", etNim.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void tambahData(String nim, String nama, String jurusan){
        //koneksi ke file create.php, jika menggunakan localhost gunakan ip sesuai dengan ip kamu
        AndroidNetworking.post("http://192.168.43.159/crud_java/create.php")
                .addBodyParameter("nim",nim) //mengirimkan data nim_mahasiswa yang akan diisi dengan varibel nim
                .addBodyParameter("nama", nama) //mengirimkan data nama_mahasiswa yang akan diisi dengan varibel nama
                .addBodyParameter("jurusan", jurusan) //mengirimkan data jurusan_mahasiswa yang akan diisi dengan varibel jurusan
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Handle Response
                        Log.d(TAG, "onResponse: " + response); //untuk log pada onresponse
                        Toast.makeText(getApplicationContext(),"Data berhasil ditambahkan" , Toast.LENGTH_SHORT).show();
                        //memunculkan Toast saat data berhasil ditambahkan

                    }
                    @Override
                    public void onError(ANError error) {
                        //Handle Error
                        Log.d(TAG, "onError: Failed" + error); //untuk log pada onerror
                        Toast.makeText(getApplicationContext(),"Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                        //memunculkan Toast saat data gagal ditambahkan
                    }
                });
    }

}











