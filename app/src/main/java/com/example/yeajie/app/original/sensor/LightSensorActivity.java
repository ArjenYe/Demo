package com.example.yeajie.app.original.sensor;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.vibrator.VibratorActivity;

/**
 * @author arjen
 */

public class LightSensorActivity extends Activity implements SensorEventListener {
    private AppCompatButton toOtherViewBtn;

    private SensorManager sensorManager;
    private PowerManager powerManager;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        toOtherViewBtn = (AppCompatButton) findViewById(R.id.to_other_view_btn);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(32, "LightSensor");
        toOtherViewBtn.setOnClickListener(v -> startActivity(new Intent(this, VibratorActivity.class)));
    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        wakeLock.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
        wakeLock.release();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        switch (event.sensor.getType()) {
            case Sensor.TYPE_PROXIMITY:
                if (values[0] <= 3F) {
                    if (!wakeLock.isHeld()) {
                        wakeLock.acquire();
                    }
                } else {
                    if (!wakeLock.isHeld()) {
                        wakeLock.setReferenceCounted(false);
                        wakeLock.release();
                    }
                }
            default:
                Log.i("Light Sensor", String.valueOf(values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
