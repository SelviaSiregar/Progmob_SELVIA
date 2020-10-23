package com.example.selvia_progmob.CRUD;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.selvia_progmob.Model.DefaultResult;
import com.example.selvia_progmob.Network.GetDataService;
import com.example.selvia_progmob.Network.RetrofitClientInstance;
import com.example.selvia_progmob.R;

import retrofit2.Call;

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);
        final EditText edNamaBaru = (EditText)findViewById(R.id.editTextNama);
        final EditText edNimBaru = (EditText)findViewById(R.id.editTextNim);
        final EditText edAlamatBaru = (EditText)findViewById(R.id.editTextAlamat);
        final EditText edEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnUbah = (Button)findViewById(R.id.buttonUbah);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menanti");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        edNamaBaru.getText().toString(),
                        edNimBaru.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmail.getText().toString(),
                        "kosongkan saja diisi sembarang karena dirandom sistem",
                        "72180183"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "DATA BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "GAGAL", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
