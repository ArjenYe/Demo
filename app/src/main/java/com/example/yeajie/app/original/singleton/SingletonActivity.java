package com.example.yeajie.app.original.singleton;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;

import com.example.platform.singleton.TimeData;
import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class SingletonActivity extends Activity {
    private AppCompatEditText yearEdt;
    private AppCompatEditText monthEdt;
    private AppCompatEditText dayEdt;
    private AppCompatButton toastBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);

        initViewLayout();
        toastBtn.setOnClickListener(view -> toastTime());
    }

    private void toastTime() {
        TimeData timeData = getTimeData();
        ToastUtil.showToast(this, "Year: "
                + timeData.getYear()
                + ", Month: "
                + timeData.getMonth()
                + ", Day: "
                + timeData.getDay());
    }

    private TimeData getTimeData() {
        return new TimeData.Builder()
                .setYear(yearEdt.getText().toString())
                .setMonth(monthEdt.getText().toString())
                .setDay(dayEdt.getText().toString())
                .create();
    }

    private void initViewLayout() {
        yearEdt = (AppCompatEditText) findViewById(R.id.year_edt);
        monthEdt = (AppCompatEditText) findViewById(R.id.month_edt);
        dayEdt = (AppCompatEditText) findViewById(R.id.day_edt);
        toastBtn = (AppCompatButton) findViewById(R.id.toast_btn);
    }
}
