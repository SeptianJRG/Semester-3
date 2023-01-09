package com.example.praktikum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Data extends AppCompatActivity {

    TextView dataSembuh, dataPositif, dataMeninggal, dataDirawat, update;
    CardView card1, card2, card3, card4;
    ProgressDialog loading;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        button2          = findViewById(R.id.btn2);

        dataSembuh      = findViewById(R.id.data_sembuh);
        dataPositif     = findViewById(R.id.data_positif);
        dataDirawat     = findViewById(R.id.data_dirawat);
        dataMeninggal   = findViewById(R.id.data_meninggal);
        update          = findViewById(R.id.lastupdate);

        tampilData();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Data.this, MainActivity.class);
                startActivity(home);
            }
        });
    }

    private void tampilData() {
        loading = ProgressDialog.show(Data.this, "Sedang Memuat", "Harap Bersabar");
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://apicovid19indonesia-v2.vercel.app/api/indonesia";
        JSONObject jsonObject = new JSONObject();
        final String requestBody = jsonObject.toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response.toString());
                    String sembuh       = json.getString("sembuh");
                    String dirawat      = json.getString("dirawat");
                    String meninggal    = json.getString("meninggal");
                    String positif      = json.getString("positif");
                    String Lastupdate   = json.getString("lastUpdate");

                    dataSembuh.setText(sembuh + "\nOrang");
                    dataDirawat.setText(dirawat + "\nOrang");
                    dataPositif.setText(positif + "\nOrang");
                    dataMeninggal.setText(meninggal + "\nOrang");
                    update.setText(Lastupdate);
                    loading.cancel();
                    Toast.makeText(Data.this, "Berhasil Memuat Data", Toast.LENGTH_SHORT).show();

                } catch (JSONException except) {
                    except.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.cancel();
                Toast.makeText(Data.this, "No Internet Connect", Toast.LENGTH_SHORT).show();
            }
        }
        );
        queue.add(stringRequest);
    }
}