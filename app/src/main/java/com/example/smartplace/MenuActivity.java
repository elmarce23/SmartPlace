package com.example.smartplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    API_Connector connector;
    Switch c1, c2, c3, c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        connector = new API_Connector();
        initComponents();

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creaMensaje(isChecked);
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

    protected void creaMensaje(boolean act){
        String cat = act ? "Encendido" : "Apagado";
        Toast.makeText(getApplicationContext(), "Dispositivo:name " + cat, Toast.LENGTH_LONG).show();
    }

}