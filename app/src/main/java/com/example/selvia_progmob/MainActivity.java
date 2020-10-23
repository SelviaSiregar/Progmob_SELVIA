package com.example.selvia_progmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.selvia_progmob.Pertemuan2.ListActivity;
import com.example.selvia_progmob.Pertemuan2.RecyclerActivity;
import com.example.selvia_progmob.Pertemuan2.cardviewtestactivity;
import com.example.selvia_progmob.Pertemuan4.DebuggingActivity;
import com.example.selvia_progmob.Pertemuan4.HelpActivity;
import com.example.selvia_progmob.Pertemuan4.TrackerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variabel
        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);
        Button button3 = (Button)findViewById(R.id.button3);
        Button btnPertemuan = (Button)findViewById(R.id.btnPertemuan) ;

        //Pertemuan2
        Button btnList = (Button)findViewById(R.id.buttonListView);
        Button btnRecyler = (Button)findViewById(R.id.buttonRecyclerView);
        Button btnCard = (Button)findViewById(R.id.buttonCardView);

       // txtView.setText(R.string.text_hello_word);
        myBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Klik", myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        }));
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                Bundle b =  new Bundle();
                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrackerActivity.class);
                startActivity(intent);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        btnRecyler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cardviewtestactivity.class);
                startActivity(intent);
            }
        });
        btnPertemuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DebuggingActivity.class);
                startActivity(intent);
            }
        });
    }
}