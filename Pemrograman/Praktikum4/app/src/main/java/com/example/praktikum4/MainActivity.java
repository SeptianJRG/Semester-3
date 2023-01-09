package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView epep, emel, ninja;
    TextView locText, orderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epep        = findViewById(R.id.CardViewIntent_1);
        emel        = findViewById(R.id.CardViewIntent_2);
        ninja       = findViewById(R.id.CardViewIntent_3);
        locText     = findViewById(R.id.text_view_order);
        orderText   = findViewById(R.id.textViewIntent_loc);

        epep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent List = new Intent(MainActivity.this,Epep.class);
                startActivity(List);
            }
        });

        emel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent List2 = new Intent(MainActivity.this,Emel.class);
                startActivity(List2);
            }
        });

        ninja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent List3 = new Intent(MainActivity.this,Ninja.class);
                startActivity(List3);
            }
        });

        locText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchMapAppIntent = new Intent(Intent.ACTION_VIEW);
                launchMapAppIntent.setData(Uri.parse("geo:-7.273946852840151, 112.79371116759155?q=Politeknik+Elektronika+Negeri+Surabaya"));
                startActivity(launchMapAppIntent);
            }
        });

        orderText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_VIEW);
                launchEmailAppIntent.setData(Uri.parse("http://www.instagram.com/sptianbgus"));
                startActivity(launchEmailAppIntent);
            }
        });

    }
}