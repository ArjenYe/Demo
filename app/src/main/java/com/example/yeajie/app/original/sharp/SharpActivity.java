package com.example.yeajie.app.original.sharp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class SharpActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharp);
        AppCompatButton mySharpBtn = (AppCompatButton) findViewById(R.id.my_sharp_btn);

    }
}
