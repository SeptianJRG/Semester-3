package com.example.parktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Panjang extends AppCompatActivity {

    double a,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panjang);

        EditText nilai;
        Button CmtoM, MtoCm, MtoKm, KmtoM, clear, change;
        TextView hasil;

        nilai = findViewById(R.id.etxtA);
        CmtoM = findViewById(R.id.btnCmtoM);
        MtoCm = findViewById(R.id.btnMtoCm);
        MtoKm = findViewById(R.id.btnMtoKm);
        KmtoM = findViewById(R.id.btnKmtoM);
        hasil = findViewById(R.id.txtHasil);
        clear = findViewById(R.id.btnClear);
        change= findViewById(R.id.btnChangee);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai.setText("");
                hasil.setText("");
            }
        });

        CmtoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilai.getText().toString());
                total = a/100;
                hasil.setText(String.valueOf(total + " m"));
            }
        });

        MtoCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilai.getText().toString());
                total = a*100;
                hasil.setText(String.valueOf(total + " cm"));
            }
        });

        MtoKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilai.getText().toString());
                total = a/1000;
                hasil.setText(String.valueOf(total + " km"));
            }
        });

        KmtoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilai.getText().toString());
                total = a*1000;
                hasil.setText(String.valueOf(total + " m"));
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Panjang.this, MainActivity.class));
            }
        });

    }
}