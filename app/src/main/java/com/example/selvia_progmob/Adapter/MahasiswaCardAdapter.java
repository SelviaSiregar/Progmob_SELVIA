package com.example.selvia_progmob.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selvia_progmob.Model.Mahasiswa;
import com.example.selvia_progmob.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaCardAdapter extends RecyclerView.Adapter<MahasiswaCardAdapter.ViewHolder> {
    private Context context;

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    private List<Mahasiswa> mahasiswaList;

    public MahasiswaCardAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MahasiswaCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaCardAdapter.ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNoTelp.setText(m.getNotelp());
        holder.tvNim.setText(m.getNim());

    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNoTelp = itemView.findViewById(R.id.tvNoTelp);


        }
    }
}


