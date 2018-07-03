package com.example.yeajie.app.original.sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;

import com.example.yeajie.app.R;

import java.util.List;

/**
 * @author arjen
 */

public class ShowAllSensorActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_sensor);

        AppCompatTextView textTxt = findViewById(R.id.text_content);
        textTxt.setText(getSensor());
    }

    public String getSensor() {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sb = new StringBuilder();

        sb.append("此手机有")
                .append(sensorList.size())
                .append("个传感器，分别有：\n");

        for (Sensor s : sensorList) {
            switch (s.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    sb.append(s.getType())
                            .append(" 加速度传感器(Accelerometer sensor)").append("\n");
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    sb.append(s.getType())
                            .append(" 陀螺仪传感器(Gyroscope sensor)").append("\n");
                    break;
                case Sensor.TYPE_LIGHT:
                    sb.append(s.getType())
                            .append(" 光线传感器(Light sensor)").append("\n");
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    sb.append(s.getType())
                            .append(" 磁场传感器(Magnetic field sensor)").append("\n");
                    break;
                case Sensor.TYPE_ORIENTATION:
                    sb.append(s.getType())
                            .append(" 方向传感器(Orientation sensor)").append("\n");
                    break;
                case Sensor.TYPE_PRESSURE:
                    sb.append(s.getType())
                            .append(" 气压传感器(Pressure sensor)").append("\n");
                    break;
                case Sensor.TYPE_PROXIMITY:
                    sb.append(s.getType())
                            .append(" 距离传感器(Proximity sensor)").append("\n");
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    sb.append(s.getType())
                            .append(" 温度传感器(Temperature sensor)").append("\n");
                    break;
                default:
                    sb.append(s.getType())
                            .append(" 其他传感器").append("\n");
                    break;
            }
            sb.append("设备名称：")
                    .append(s.getName())
                    .append("\n 设备版本：")
                    .append(s.getVersion())
                    .append("\n 供应商：")
                    .append(s.getVendor())
                    .append("\n");
        }

        return sb.toString();
    }
}
