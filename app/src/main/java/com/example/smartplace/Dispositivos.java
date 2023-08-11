package com.example.smartplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Dispositivos extends AppCompatActivity {

    //LOGCAT
    private static final String TAG = "Dispositivos";
    //Declara la lista
    ListView lista;
    public static String EXTRA_DEVICE_ADDRESS = "device_address";

    //Bluetooth
    private BluetoothAdapter mBtAdapter;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivos);
    }

    @Override
    protected void onResume() {
        super.onResume();

        verificarEstadoBT();
        //Inicializa el List
        arrayAdapter = new ArrayAdapter(this, R.layout.activity_dispositivos);
        lista = (ListView) findViewById(R.id.listaDis);
        lista.setAdapter(arrayAdapter);
        lista.setOnItemClickListener(mclickListener);

        mBtAdapter = BluetoothAdapter.getDefaultAdapter();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();

        if(pairedDevices.size() > 0){
            for(BluetoothDevice device : pairedDevices)
                arrayAdapter.add(device.getName() + "\n" + device.getAddress());
        }

    }

    private AdapterView.OnItemClickListener mclickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String info = ((TextView) view).getText().toString();
            String address = info.substring(info.length() - 17);

            finishAffinity();

            Intent intent = new Intent(Dispositivos.this, MenuActivity.class);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
            startActivity(intent);

        }
    };

    private void verificarEstadoBT() {
        //Comprueba BT Activo
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBtAdapter == null) {
            Toast.makeText(getBaseContext(), "No Bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (mBtAdapter.isEnabled()) {
                Log.d(TAG, "Activated");
            } else {
                //Solicita activar Bluetooth
                Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivityForResult(enableIntent, 1);
            }
        }

    }
}