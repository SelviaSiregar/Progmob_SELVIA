package com.example.selvia_progmob.Pertemuan2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selvia_progmob.Adapter.MahasiswaCardAdapter;
import com.example.selvia_progmob.Model.Mahasiswa;
import com.example.selvia_progmob.R;

import java.util.ArrayList;
import java.util.List;

public class cardviewtestactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardviewtestactivity);
        RecyclerView rv = (RecyclerView)findViewById(R.id.RvLatihan);
        //MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;
        MahasiswaCardAdapter mahasiswaCardAdapter;

        //datadummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Selvia", "72180265", "081325467987");
        Mahasiswa m2 = new Mahasiswa("Ester", "72180264", "082142546789");
        Mahasiswa m3 = new Mahasiswa("Nanda", "72180249", "087816276589");
        Mahasiswa m4 = new Mahasiswa("Kiki", "71180238", "081265768909");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);

        mahasiswaCardAdapter = new MahasiswaCardAdapter(cardviewtestactivity.this);
        mahasiswaCardAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(cardviewtestactivity.this));
        rv.setAdapter(mahasiswaCardAdapter);


    }
}
