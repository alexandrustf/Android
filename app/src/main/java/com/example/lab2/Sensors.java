package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Sensors extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    List<Sensor> deviceSensors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);


        TextView textView = (TextView) findViewById(R.id.textView4);
        String sensors ="List of sensors on this device: \n";
        for (Sensor sensor : deviceSensors) {
            sensors += sensor.getName() + " \n";
        }
        textView.setText(sensors);


    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
