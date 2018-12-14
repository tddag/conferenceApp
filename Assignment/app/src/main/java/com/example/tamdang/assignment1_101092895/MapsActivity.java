package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  MapsActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    TextView textViewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                finish();
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Button btnShowMap = findViewById(R.id.btnShowMap);
        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CollegeMapActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] v = event.values;

        textViewMap = findViewById(R.id.textViewMap);

        //
        float sqrt = (v[0]*v[0]+v[1]*v[1]+v[2]*v[2])/
                (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        textViewMap.setText("sqrt:" + sqrt);
        if(sqrt>=2){
            textViewMap.setBackgroundColor(Color.RED);
        }else{
            textViewMap.setBackgroundColor(Color.WHITE);
        }

        textViewMap.setText("X:" + v[0] + " Y:" + v[1] + " Z:" + v[2]);




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
