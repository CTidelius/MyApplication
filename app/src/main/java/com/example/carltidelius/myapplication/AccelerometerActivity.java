package com.example.carltidelius.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private TextView X, Y, Z;
    private Sensor sensor;
    private SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        //creates a sensormanager
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Sensor for accelerometer
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //register sensorlistener
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);

        //Assign textviews
        X = (TextView)findViewById(R.id.X);
        Y = (TextView)findViewById(R.id.Y);
        Z = (TextView)findViewById(R.id.Z);




    }



    public void goBack(View view) {
        finish();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        X.setText("X: " + Math.round(event.values[0]));
        Y.setText("Y: " + Math.round(event.values[1]));
        Z.setText("Z: " + Math.round(event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this, sensor);

    }
}
