package com.example.smartplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDelay(800);
    }

    private void setDelay(int Delay){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment content = new MainFrame();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.FCV1, content).commit();
            }
        }, Delay);
    }

}