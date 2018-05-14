package com.example.yeajie.app.original.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class CheckBoxActivity extends Activity {
    private AppCompatCheckBox checkBox_1;
    private AppCompatCheckBox checkBox_2;
    private AppCompatCheckBox checkBox_3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        //origin
        checkBox_1 = (AppCompatCheckBox) findViewById(R.id.check_box_1);

        //set bg
        checkBox_2 = (AppCompatCheckBox) findViewById(R.id.check_box_2);

        //set theme
        checkBox_3 = (AppCompatCheckBox) findViewById(R.id.check_box_3);

    }
}
