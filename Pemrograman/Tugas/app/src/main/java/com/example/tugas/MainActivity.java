package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.Period;


public class MainActivity extends AppCompatActivity {

    public static int HitungUmur(LocalDate dob)
    {
        LocalDate skrg = LocalDate.now();

        if ((dob != null) && (skrg != null))
        {
            return Period.between(dob, skrg).getYears();
        }
        else
        {
            return 0;
        }
    }

    public static int HitungUmurBln(LocalDate dob)
    {
        LocalDate skrg = LocalDate.now();

        if ((dob != null) && (skrg != null))
        {
            return Period.between(dob, skrg).getMonths();
        }
        else
        {
            return 0;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit;
        EditText bb, tb, tl;
        TextView s_ideal, s_umur, s_kategori, s_tinggi;
        Spinner spinner;

        submit = findViewById(R.id.btnsubmit);
        bb = findViewById(R.id.databerat);
        tb = findViewById(R.id.datatinggi);
        tl = findViewById(R.id.datatgl);
        s_ideal     = findViewById(R.id.texthasil);
        s_umur      = findViewById(R.id.textumur);
        s_kategori  = findViewById(R.id.textkategori);
        s_tinggi    = findViewById(R.id.textkategori2);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.umur, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tinggi, berat, hasil;
                int umur_asli;
                String hasil_ideal, tglLahir, KU, htg, tinggi_ideal = "";

                tinggi = Double.parseDouble(tb.getText().toString());
                berat = Double.parseDouble(bb.getText().toString());
                KU = spinner.getSelectedItem().toString();

                tglLahir = tl.getText().toString();

                LocalDate dob = LocalDate.parse(tglLahir);

                if((tinggi>=HitungUmurBln(dob)*6+77) && (HitungUmur(dob)>=2) && (HitungUmur(dob)<=12)){
                    tinggi_ideal = "ideal";
                }
                else if((tinggi<85) && (HitungUmur(dob)<1)){
                    tinggi_ideal = "ideal";
                }

                if (HitungUmur(dob)>=1){
                    umur_asli = HitungUmur(dob);
                    htg = "tahun";
                    hasil = (HitungUmur(dob)*2)+8;
                    if(berat>=hasil){
                        hasil_ideal = "Gizi Baik";
                    }else{
                        hasil_ideal = "Gizi Buruk";
                    }
                }
                else if (HitungUmur(dob)>=7){
                    umur_asli = HitungUmur(dob);
                    htg = "tahun";
                    hasil = ((HitungUmur(dob)*7)-5)/2;
                    if(berat>=hasil){
                        hasil_ideal = "Gizi Baik";
                    }else{
                        hasil_ideal = "Gizi Buruk";
                    }
                }
                else{
                    umur_asli = HitungUmurBln(dob);
                    htg = "bulan";
                    hasil = (HitungUmurBln(dob)+9)/2;
                    if(berat>=hasil){
                        hasil_ideal = "Gizi Baik";
                    }else{
                        hasil_ideal = "Gizi Buruk";
                    }
                }
                s_ideal.setText("Hasil : " + hasil_ideal);
                s_umur.setText("Umur : " + umur_asli + " " + htg);
                s_kategori.setText("Kategori : " + KU);
                s_tinggi.setText("Tinggi : " + tinggi_ideal);
            }
        });


    }
}