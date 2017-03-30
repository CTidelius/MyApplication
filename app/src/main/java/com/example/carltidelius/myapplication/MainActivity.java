package com.example.carltidelius.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Do Things button */
    public void accelerometer(View view) {
        Intent intent = new Intent(this, AccelerometerActivity.class);
        startActivity(intent);
    }
    /** Called when the use taps the Do Compass Things button*/
    public void compass(View view){
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);

    }
}
