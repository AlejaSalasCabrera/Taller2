package com.i012114.taller2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.i012114.taller2.Adapters.AdapterCountry;
import com.i012114.taller2.Connection.HttpManager;
import com.i012114.taller2.Models.Country;
import com.i012114.taller2.Parser.JsonCountry;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    RecyclerView recyclerView;
    List<Country> countryList;
    AdapterCountry adapterCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        progressBar = (ProgressBar) findViewById(R.id.id_pb_item);
        button = (Button) findViewById(R.id.id_btn_listcountries);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void processData(){
        adapterCountry = new AdapterCountry(countryList, getApplicationContext());
        recyclerView.setAdapter(adapterCountry);
    }


    // Metodo para validar la conexion a internet
    public Boolean isOnLine(){
// Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
// Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
// Validar el estado obtenido de la conexion
        if (networkInfo != null){
            return true;
        }else {
            return false;
        }
    }
    public void loadData(View view){
        if (isOnLine()){
            TaskCountry taskCountry = new TaskCountry();
            taskCountry.execute("https://restcountries.eu/rest/v2/lang/es");
        }else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public class TaskCountry extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                countryList = JsonCountry.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            processData();
            progressBar.setVisibility(View.GONE);
        }
    }
}
