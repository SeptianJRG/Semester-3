package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] divisi = {"JOBDESK", "Manager", "Coach", "Team Leader", "Player"};

    double gajiPokok, tunjuangan;

    Spinner jobdesk;
    EditText Nama, Hari, Lembur;
    Button tombol;
    TextView hasil;

    private void findViews(){
        jobdesk = findViewById(R.id.spinner);
        Nama    = findViewById(R.id.etxNama);
        Hari    = findViewById(R.id.etxHari);
        Lembur  = findViewById(R.id.etxLembur);
        hasil   = findViewById(R.id.txtView);
        tombol  = findViewById(R.id.button);

    }

    private void upah(int divisi, String hariKerja, String jamLembur){
        double nilaiHari = Integer.parseInt(hariKerja);
        double nilaiLembur = Integer.parseInt(jamLembur);

        double persen = 0;

        for(int i=1; i<=nilaiHari;++i){
            if(nilaiHari >=20)
                persen = 1;
            else
                persen += 0.05;
        }
        for(int i=1; i<=nilaiLembur;++i){
            persen += 0.005;
        }

        switch(divisi){
            case 0:
                gajiPokok = 0;
                tunjuangan = 0;
                break;
            case 1:
                gajiPokok = 5000000 * persen;
                tunjuangan= 2000000 * persen;
                break;
            case 2:
                gajiPokok = 3000000 * persen;
                tunjuangan= 1500000 * persen;
                break;
            case 3:
                gajiPokok = 2000000 * persen;
                tunjuangan= 1000000 * persen;
                break;
            case 4:
                gajiPokok = 1000000 * persen;
                tunjuangan= 500000  * persen;
                break;
        }
    }

    private String totalGaji(double gajiPokok, double tunjuangan){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        double hasil = gajiPokok + tunjuangan;
        return formatRupiah.format(hasil);
        //return gajiPokok+tunjuangan;
    }

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,divisi);
        jobdesk.setAdapter(adapter);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
                String tanggalSekarang = tanggal.format(new Date());

                String nama = Nama.getText().toString();
                String hariKerja = Hari.getText().toString();
                String jamLembur = Lembur.getText().toString();
                int divisi = jobdesk.getSelectedItemPosition();
                //double gaji = totalGaji(gajiPokok,tunjuangan);

                if(divisi==0 || nama.isEmpty() || hariKerja.isEmpty() || jamLembur.isEmpty()){
                    if(divisi==0)Toast.makeText(MainActivity.this, "Silahkan Pilih Jobdesk Anda", Toast.LENGTH_SHORT).show();
                    else if(nama.isEmpty())Toast.makeText(MainActivity.this, "Silahkan Masukkan Nama Anda", Toast.LENGTH_SHORT).show();
                    else if(hariKerja.isEmpty())Toast.makeText(MainActivity.this, "Silahkan Masukkan Total Kehadiran Anda", Toast.LENGTH_SHORT).show();
                    else Toast.makeText(MainActivity.this, "Silahkan Masukkan Total Lembur Anda", Toast.LENGTH_SHORT).show();
                    hasil.setText("");
                }
                else{

                    upah(divisi, hariKerja, jamLembur);

                    //hasil.setText(String.format("Nama: %s\nJobdesk: %s\nTanggal: %s\nTotal Gaji: Rp.%d", nama,jobdesk.getSelectedItem(), tanggalSekarang, (int)totalGaji(gajiPokok, tunjuangan)));
                    hasil.setText(  "Nama: " + nama +
                                    "\nJobDesk: " + jobdesk.getSelectedItem() +
                                    "\nTanggal: " + tanggalSekarang +
                                    "\nTotal Gaji: " + totalGaji(gajiPokok,tunjuangan));

                }

            }
        });

    }
}