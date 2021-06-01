package com.example.rabia_rc_arac;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bltAdapter;
    Button acbutonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bltAdapter=BluetoothAdapter.getDefaultAdapter();
        acbutonu=(Button) findViewById(R.id.btn_ac);

        acbutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateBluetooth();
            }
        });
    }

    private void activateBluetooth() {
        if (bltAdapter == null){
            Toast.makeText(getApplicationContext(),"Cihazınızda Bluetooth OZelligi Yok",Toast.LENGTH_SHORT).show();
        }

        if (!bltAdapter.isEnabled()){

            Intent bltIntent= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(bltIntent);
        }
        if (bltAdapter.isEnabled()){
            bltAdapter.disable();
        }

    }
}