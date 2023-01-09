package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Epep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epep);

        ListView startersList = findViewById(R.id.lstItem);
        Button btn = findViewById(R.id.btnNinja);

        Dish[] dishes = {
                new Dish("Promo 355 Amunisi","Mendapatkan 155+200 Amunisi",70000),
                new Dish("Promo 720 Amunisi","Mendapatkan 600+120 Amunisi",98000),
                new Dish("Promo 1080 Amunisi","Mendapatkan 720+360 Amunisi",145000),
                new Dish("Promo 1440 Amunisi","Mendaptkan 1080+360 Amunisi",195000),
                new Dish("Promo 2000 Amunisi","Mendaptkan 1440+560 Amunisi",270000),
                new Dish("Promo 2720 Amunisi","Mendapatkan 2000+720 Amunisi",350000),
                new Dish("Promo 3440 Amunisi","Mendapatkan 2720+720 Amunisi",450000),
                new Dish("Promo 4000 Amunisi","Mendaptkan 3440+560 Amunisi",520000),
                new Dish("Promo 6000 Amunisi","Mendaptkan 4000+2000 Amunisi",780000),
                new Dish("Promo Membership Mingguan","Mendapatkan 100 Amunisi tiap hari",30000)

        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dishes);
        startersList.setAdapter(dishAdapter);

        startersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dish ds = dishAdapter.getItem(i);
                Toast toast = Toast.makeText(getApplicationContext(),ds.getDesc(),Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(Epep.this,MainActivity.class);
                startActivity(menu);
            }
        });



    }
}