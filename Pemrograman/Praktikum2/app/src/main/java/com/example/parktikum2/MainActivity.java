package com.example.parktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nilaiA, nilaiB;
    Button tambah,kurang,kali,bagi,clear,change;
    TextView txthasil;

    double a,b,hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilaiA    = findViewById(R.id.etxtA);
        nilaiB    = findViewById(R.id.etxtB);
        tambah    = findViewById(R.id.btnCmtoM);
        kurang    = findViewById(R.id.btnMtoKm);
        bagi      = findViewById(R.id.btnKmtoM);
        kali      = findViewById(R.id.btnMtoCm);
        clear     = findViewById(R.id.btnClear);
        txthasil  = findViewById(R.id.txtHasil);
        change    = findViewById(R.id.btnChange);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiA.setText("");
                nilaiB.setText("");
                txthasil.setText("");
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilaiA.getText().toString());
                b = Double.parseDouble(nilaiB.getText().toString());
                hasil = a + b;
                txthasil.setText(String.valueOf(hasil));
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilaiA.getText().toString());
                b = Double.parseDouble(nilaiB.getText().toString());
                hasil = a - b;
                txthasil.setText(String.valueOf(hasil));
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilaiA.getText().toString());
                b = Double.parseDouble(nilaiB.getText().toString());
                hasil = a * b;
                txthasil.setText(String.valueOf(hasil));
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Double.parseDouble(nilaiA.getText().toString());
                b = Double.parseDouble(nilaiB.getText().toString());
                hasil = a / b;
                txthasil.setText(String.valueOf(hasil));
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Panjang.class));
            }
        });

    }
}