package com.kevin.btfixer;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    TextView btStatusField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStatusField = findViewById(R.id.btStatusField);
        if (!mBluetoothAdapter.isEnabled()) {
            btStatusField.setText("Bluetooth off");


        }else{
            btStatusField.setText("Bluetooth on");

        }

    }

    public void runTasks(View view){

        btStatusField = findViewById(R.id.btStatusField);

            if (!mBluetoothAdapter.isEnabled()) {
                findViewById(R.id.textView);
                Toast.makeText(this, "bluetooth is off, enabling now", Toast.LENGTH_SHORT).show();
                try {
                     btStatusField.setText("Bluetooth off");
                    Thread.sleep(24000);



                    mBluetoothAdapter.enable();
                    btStatusField.setText("Bluetooth on");
                    Toast.makeText(this, "Bluetooth enabled now", Toast.LENGTH_SHORT).show();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }else{
                btStatusField.setText("Bluetooth on");
                Toast.makeText(this, "bluetooth is on", Toast.LENGTH_SHORT).show();

            }



    }
}
