package id.topan.fan_crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import java.util.List;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ViewHolder> {

    private List<DataMahasiswa> dataMahasiswa; //inisialisasi List dengan object DataMahasiswa


    //construktor ListMahasiswaAdapter
    public ListMahasiswaAdapter(List<DataMahasiswa> dataMahasiswa) {
        this.dataMahasiswa = dataMahasiswa;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view yang akan digunakan yaitu layout list_mahasiswa_row.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahasiswa_row, parent, false);
        ViewHolder holder = new ViewHolder(v); //inisialisasi ViewHolder
        return holder;
    } //fungsi yang dijalankan saat ViewHolder dibuat

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataMahasiswa data = dataMahasiswa.get(position); //inisialisasi object DataMahasiwa
        holder.mNama.setText(data.getNamaMahasiswa()); //menset value view "mNama" sesuai data dari getNamaMahasiswa();
        holder.mNim.setText(data.getNamaMahasiswa()); //menset value view "mNim" sesuai data dari getNimMahasiswa();
    }


    @Override
    public int getItemCount() {
        return dataMahasiswa.size(); //mengambil item sesuai urutan
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mNama, mNim; //inisialisasi variabel

        public ViewHolder(View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.textListMahasiswaNama); //find layout sesuai dengan yg di list_mahasiswa_row.xml
            mNim = itemView.findViewById(R.id.textListMahasiswaNim); //find layout sesuai dengan yg di list_mahasiswa_row.xml
        }
    }
}