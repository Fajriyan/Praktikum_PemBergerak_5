package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button tambahdata,lihatdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambahdata = (Button)findViewById(R.id.tambahdata);
        lihatdata  = (Button) findViewById(R.id.lihatdata);

        tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TambahData.getActiveIntent(MainActivity.this));
            }
        });

        lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(View_Data.getActiveIntent(MainActivity.this));
            }
        });

    }
}
