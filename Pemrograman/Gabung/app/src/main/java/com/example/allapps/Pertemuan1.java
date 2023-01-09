package com.example.allapps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pertemuan1 extends AppCompatActivity {

    boolean kondisi = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button klik = findViewById(R.id.button);
        TextView txt = findViewById(R.id.textView);

        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kondisi){
                    txt.setText("Hello, Good Afternoon");
                    kondisi = false;
                }
                else{
                    txt.setText("Septian Bagus Jumantoro\n" +
                            "3221600039\n" +
                            "2D4 Teknik Komputer B");
                    kondisi = true;
                }
            }
        });

    }
}