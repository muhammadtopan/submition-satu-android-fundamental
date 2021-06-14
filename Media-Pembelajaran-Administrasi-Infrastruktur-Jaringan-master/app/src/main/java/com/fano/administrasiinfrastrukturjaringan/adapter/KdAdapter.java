package com.fano.administrasiinfrastrukturjaringan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fano.administrasiinfrastrukturjaringan.IsiMateriActivity;
import com.fano.administrasiinfrastrukturjaringan.R;
import com.fano.administrasiinfrastrukturjaringan.model.DataKd;

import java.util.ArrayList;

public class KdAdapter extends RecyclerView.Adapter<KdAdapter.ListViewHolder>  {
    private ArrayList<DataKd> dataKd;
    private Context context;

    public KdAdapter(ArrayList<DataKd> dataKd, Context context) {
        this.dataKd = dataKd;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kd, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        DataKd data = dataKd.get(position);
        holder.imgLogo.setImageResource(data.getGambarKd());
        holder.tvKd.setText(data.getKd());
        holder.tvJudul.setText(data.getJudulKd());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IsiMateriActivity.class);
                intent.putExtra(IsiMateriActivity.EXTRA_KD, dataKd.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKd.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView tvKd, tvJudul;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLogo = itemView.findViewById(R.id.logo_kd);
            tvKd = itemView.findViewById(R.id.kd);
            tvJudul = itemView.findViewById(R.id.judul_kd);
        }
    }
}
