package com.example.yeajie.app.original.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class OrientationSensorActivity extends Activity implements SensorEventListener {
    private AppCompatTextView xPositionTxt;
    private AppCompatTextView yPositionTxt;
    private AppCompatTextView zPositionTxt;

    private SensorManager sensorManager;
    private Sensor orientationSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_sensor);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_UI);

        xPositionTxt = (AppCompatTextView) findViewById(R.id.x_position_txt);
        yPositionTxt = (AppCompatTextView) findViewById(R.id.y_position_txt);
        zPositionTxt = (AppCompatTextView) findViewById(R.id.z_position_txt);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        zPositionTxt.setText("方位角：" + (float) (Math.round(sensorEvent.values[0] * 100)) / 100);
        yPositionTxt.setText("倾斜角：" + (float) (Math.round(sensorEvent.values[1] * 100)) / 100);
        xPositionTxt.setText("滚动角：" + (float) (Math.round(sensorEvent.values[2] * 100)) / 100);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}
