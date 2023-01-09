package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text;
        Button satu, dua, tiga;

        satu = findViewById(R.id.pert1);
        dua = findViewById(R.id.pert2);
        tiga = findViewById(R.id.pert3);

        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pertemuan1 = new Intent(MainActivity.this, Pertemuan1.class);
                startActivity(pertemuan1);
            }
        });

    }
}