package com.gritacademy.sensorproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {
    private double accelerationValueDifference;
    private double currentValue;
    private double previousValue;
    private ProgressBar progressBar;
    private SensorManager sensorManager;
    private TextView xValueDisplay;
    private TextView yValueDisplay;
    private TextView zValueDisplay;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        xValueDisplay = findViewById(R.id.xValue);
        yValueDisplay = findViewById(R.id.yValue);
        zValueDisplay = findViewById(R.id.zValue);
        progressBar = findViewById(R.id.progressBar);
        imageView=findViewById(R.id.imageView2);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d("momo", "onSensorChanged:x " + event.values[0] + "y:" + event.values[1] + "z:" + event.values[2]);
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        currentValue = Math.sqrt(x * x + y * y + z * z);
        accelerationValueDifference = Math.abs(currentValue - previousValue);
        previousValue = currentValue;

        xValueDisplay.setText("x value :" + (int) x);
        yValueDisplay.setText("y value:" + (int) y);
        zValueDisplay.setText("z value :" + (int) z);



        progressBar.setProgress((int) accelerationValueDifference);

        if (x>2){
            imageView.setImageResource(R.drawable.th);

        }
        if (y>11){
            imageView.setImageResource(R.drawable.resource_super);

        }
        if (z>2){
            imageView.setImageResource(R.drawable.rainbow);
        }
       }
    @Override
    protected void onResume () {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause () {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}