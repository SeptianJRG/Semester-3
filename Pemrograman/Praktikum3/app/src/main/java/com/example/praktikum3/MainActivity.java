package com.example.praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText tinggiEdit;
    Button hitungButton;
    TextView hasilText;

    private void findViews(){
        tinggiEdit = findViewById(R.id.etx);
        hitungButton = findViewById(R.id.button);
        hasilText = findViewById(R.id.textView);

    }
    private double hitungTinggi(String height){
        int input = Integer.parseInt(height);
        return input/30.48;
    }
    private void tampilHasil(double result){
        DecimalFormat koma = new DecimalFormat("0.00");
        String hasil = koma.format(result);
        hasilText.setText(hasil + " ft");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = tinggiEdit.getText().toString();
                if(height.isEmpty()){
                    Toast.makeText(MainActivity.this, "Silahkan mengisikan tinggi badan", Toast.LENGTH_SHORT).show();
                }
                else{
                    double result = hitungTinggi(height);
                    tampilHasil(result);
                }
            }
        });
    }

}