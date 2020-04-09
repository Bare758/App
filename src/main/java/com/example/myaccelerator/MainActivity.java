package com.example.myaccelerator;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    //private object variables

    ImageView pic_lion;

    private TextView xText, yText, zText;
    private Sensor mySensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create our sensor manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

            //Accelerator sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign text view
        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);

        pic_lion = findViewById(R.id.pic_lion);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

            float x = pic_lion.getRotation();
            if (x < 80.0f || x < -80.0f)
        {


            if (event.values[0] > 7.0f && event.values[1] < 7.5f) {
                pic_lion.setRotation(90);
            } else if (event.values[0] < -7.0f && event.values[1] < 7.5f) {
                pic_lion.setRotation(- 90);

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //not in use
    }
}
