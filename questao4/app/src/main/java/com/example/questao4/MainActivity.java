package com.example.questao4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView lightValue, proximityValue;
    Button getGPSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SensorManager sensorManager;
        Sensor light, proximity;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = findViewById(R.id.lightValue);
        proximityValue = findViewById(R.id.proximityValue);
        getGPSBtn = (Button) findViewById(R.id.button);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION },123);

        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                GPSTracker g =  new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!= null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: " + lat +  " LONG: "  +
                        longi, Toast.LENGTH_LONG).show();
                }
            }
        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (light != null) {
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            lightValue.setText("Light sensor not supported");
        }

        if (proximity != null) {
            sensorManager.registerListener(MainActivity.this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            proximityValue.setText("Proximity sensor not supported");
        }

    }

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light intensity: " + event.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            proximityValue.setText("Proximity: " + event.values[0]);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}