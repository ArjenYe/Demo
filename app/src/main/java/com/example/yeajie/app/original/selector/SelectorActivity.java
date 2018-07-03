package com.example.yeajie.app.original.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.LinearLayout;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class SelectorActivity extends FragmentActivity {
    private LinearLayout contentLayout;
    private AppCompatButton showStepBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selector);
        contentLayout = findViewById(R.id.content_layout);
        showStepBtn = findViewById(R.id.show_step_btn);

        contentLayout.setOnClickListener(view -> {

        });
    }
}
