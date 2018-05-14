package com.example.yeajie.app.original.timepick;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.timecountdown.CountDownTimeActivity;
import com.jakewharton.rxbinding.view.RxView;

import java.util.Calendar;

/**
 * @author arjen
 */

public class TimePickActivity extends Activity {
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pick);

        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, CountDownTimeActivity.class);
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        RxView.clicks(findViewById(R.id.set_alarm_btn)).subscribe(view -> showTimePickDialog());
    }

    private void showTimePickDialog() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        new TimePickerDialog(this, (view, hourOfDay, minute1) ->
                setAlarm(hourOfDay, minute1), hour, minute, true)
                .show();
    }

    private void setAlarm(int hourOfDay, int minute) {
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}
