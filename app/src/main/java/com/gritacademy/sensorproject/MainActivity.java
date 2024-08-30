package com.gritacademy.sensorproject;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity{

    private Spinner spinner;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        spinner = (Spinner) findViewById(R.id.list);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.colors_array,
                android.R.layout.simple_spinner_item
        );


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        btn.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case 1:
                        btn.setBackgroundColor(getResources().getColor(R.color.black));
                        break;
                    case 2:
                        btn.setBackgroundColor(getResources().getColor(R.color.purple));
                        break;
                    case 3:
                        btn.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

    }

}