package com.example.mactum;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class TampilTumbuhan extends AppCompatActivity {

    private EditText editTextKode;
    private EditText editTextNama;
    private EditText editTextJenis;



    private String kode_tumbuhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_tumbuhan);

        Intent intent = getIntent();

        kode_tumbuhan = intent.getStringExtra(Konfigurasi.EMP_ID);

        editTextKode = (EditText) findViewById(R.id.editTextKode);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextJenis = (EditText) findViewById(R.id.editTextJenis);

        editTextJenis.setText(kode_tumbuhan);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilTumbuhan.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Konfigurasi.URL_GET_EMP,kode_tumbuhan);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String Kode = c.getString(Konfigurasi.TAG_ID);
            String Nama = c.getString(Konfigurasi.TAG_NAMA);
            String Jenis = c.getString(Konfigurasi.TAG_JENIS);

            editTextKode.setText(Kode);
            editTextNama.setText(Nama);
            editTextJenis.setText(Jenis);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
