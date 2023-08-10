package com.example.smartplace;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartplace.data.Dispositivo;
import com.example.smartplace.remote.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    //API_Connector connector;
    Switch c1, c2, c3, c4;

    private TextView mResponseTv;
    private ApiService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        //connector = new API_Connector();
        initComponents();

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creaMensaje("1", isChecked);
                //connector.putEstado(2); // Debe reemplazar a isChecked
            }
        });

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creaMensaje("1", isChecked);
                //connector.putEstado(2); // Debe reemplazar a isChecked
            }
        });

        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creaMensaje("1", isChecked);
                //connector.putEstado(2); // Debe reemplazar a isChecked
            }
        });

        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creaMensaje("1", isChecked);
                //connector.putEstado(2); // Debe reemplazar a isChecked
            }
        });

    }

    private void initComponents(){
        c1 = findViewById(R.id.switch1);
        c2 = findViewById(R.id.switch2);
        c3 = findViewById(R.id.switch3);
        c4 = findViewById(R.id.switch4);
    }

    protected void creaMensaje(String id, boolean act){
        String cat = act ? "Encendido" : "Apagado";
        putDis(id, cat);
        Toast.makeText(getApplicationContext(), "Dispositivo:name " + cat, Toast.LENGTH_LONG).show();
    }

    public void putDis(String id, String edo){
        edo = edo.equals("Encendido") ? "1" : "0";
        mAPIService.putDis(id, edo).enqueue(new Callback<Dispositivo>() {
            @Override
            public void onResponse(Call<Dispositivo> call, Response<Dispositivo> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Disp. updated to API." + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Dispositivo> call, Throwable t) {
                Log.e(TAG, "Unable to update to API.");
            }
        });
    }
    public void sendPost(String nombre, String estado, String ubic) {
        mAPIService.savePost(nombre, estado, ubic).enqueue(new Callback<Dispositivo>() {
            @Override
            public void onResponse(Call<Dispositivo> call, Response<Dispositivo> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Dispositivo> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }
    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

}