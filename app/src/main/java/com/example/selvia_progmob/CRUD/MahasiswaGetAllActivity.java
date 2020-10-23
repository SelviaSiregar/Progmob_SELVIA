package com.example.selvia_progmob.CRUD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.selvia_progmob.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.selvia_progmob.Model.Mahasiswa;
import com.example.selvia_progmob.Network.GetDataService;
import com.example.selvia_progmob.Network.RetrofitClientInstance;
import com.example.selvia_progmob.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MahasiswaGetAllActivity extends AppCompatActivity {

    RecyclerView rvMhs;
    MahasiswaCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);

        rvMhs = (RecyclerView)findViewById(R.id.rvMhsAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Tunggu");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa("72180265");

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MahasiswaCRUDRecyclerAdapter(mahasiswaList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaGetAllActivity.this);
                rvMhs.setLayoutManager(layoutManager);
                rvMhs.setAdapter(mhsAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<Mahasiswa>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MahasiswaGetAllActivity.this, "Error", Toast.LENGTH_LONG);
            }
        });


    }
}