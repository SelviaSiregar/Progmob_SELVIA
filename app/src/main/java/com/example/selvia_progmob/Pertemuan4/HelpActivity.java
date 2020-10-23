package com.example.selvia_progmob.Pertemuan4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.selvia_progmob.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView txtHelp = (TextView)findViewById(R.id.textViewHelp);

        Bundle b = getIntent().getExtras();
        String textHelp = b.getString("help_string");
        txtHelp.setText(textHelp);
    }
}
