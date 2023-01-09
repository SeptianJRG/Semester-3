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

public class Ninja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninja);

        ListView startersList = findViewById(R.id.lstItem);
        Button btn = findViewById(R.id.btnNinja);

        Dish[] dishes = {
                new Dish("Promo 355 Cakra","Mendapatkan 155+200 Cakra",70000),
                new Dish("Promo 720 Cakra","Mendapatkan 600+120 Cakra",98000),
                new Dish("Promo 1080 Cakra","Mendapatkan 720+360 Cakra",145000),
                new Dish("Promo 1440 Cakra","Mendaptkan 1080+360 Cakra",195000),
                new Dish("Promo 2000 Cakra","Mendaptkan 1440+560 Cakra",270000),
                new Dish("Promo 2720 Cakra","Mendapatkan 2000+720 Cakra",350000),
                new Dish("Promo 3440 Cakra","Mendapatkan 2720+720 Cakra",450000),
                new Dish("Promo 4000 Cakra","Mendaptkan 3440+560 Cakra",520000),
                new Dish("Promo 6000 Cakra","Mendaptkan 4000+2000 Cakra",780000),
                new Dish("Promo Membership Mingguan","Mendapatkan 100 Cakra tiap hari",30000)

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
                Intent menu = new Intent(Ninja.this,MainActivity.class);
                startActivity(menu);
            }
        });



    }
}