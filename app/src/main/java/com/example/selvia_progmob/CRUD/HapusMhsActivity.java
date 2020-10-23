package com.example.selvia_progmob.CRUD;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.selvia_progmob.Model.DefaultResult;
import com.example.selvia_progmob.Network.GetDataService;
import com.example.selvia_progmob.Network.RetrofitClientInstance;
import com.example.selvia_progmob.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HapusMhsActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_mhs);
        final EditText edHapusNim = (EditText)findViewById(R.id.editTextNim);
        Button btnHapus = (Button)findViewById(R.id.buttonHapus);
        pd = new ProgressDialog(HapusMhsActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon menanti");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_mhs(
                        edHapusNim.getText().toString(),
                        "7218065"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusMhsActivity.this, "DATA BERHASIL DIHAPUS", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusMhsActivity.this, "GAGAL", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
