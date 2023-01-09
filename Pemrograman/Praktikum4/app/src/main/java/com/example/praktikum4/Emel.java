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

public class Emel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emel);

        ListView startersList = findViewById(R.id.lstItem);
        Button btn = findViewById(R.id.btnEmel);

        Dish[] dishes = {
                new Dish("Promo 355 Diamond","Mendapatkan 155+200 Diamond",70000),
                new Dish("Promo 720 Diamond","Mendapatkan 600+120 Diamond",98000),
                new Dish("Promo 1080 Diamond","Mendapatkan 720+360 Diamond",145000),
                new Dish("Promo 1440 Diamond","Mendaptkan 1080+360 Diamond",195000),
                new Dish("Promo 2000 Diamond","Mendaptkan 1440+560 Diammond",270000),
                new Dish("Promo 2720 Diamond","Mendapatkan 2000+720 DIamond",350000),
                new Dish("Promo 3440 Diamond","Mendapatkan 2720+720 Diamond",450000),
                new Dish("Promo 4000 Diamond","Mendaptkan 3440+560 Diamond",520000),
                new Dish("Promo 6000 Diamond","Mendaptkan 4000+2000 Diamond",780000),
                new Dish("Promo Membership Mingguan","Mendapatkan 100 Diamond tiap hari",30000)

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
                Intent menu = new Intent(Emel.this,MainActivity.class);
                startActivity(menu);
            }
        });



    }
}