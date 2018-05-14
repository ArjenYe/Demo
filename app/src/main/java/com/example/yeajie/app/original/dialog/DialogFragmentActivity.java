package com.example.yeajie.app.original.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class DialogFragmentActivity extends FragmentActivity {
    private AppCompatButton showDialogBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        initViewLayout();

        MyDialogFragment myDialogFragment = new MyDialogFragment();

        showDialogBtn.setOnClickListener(view ->
                myDialogFragment.show(getSupportFragmentManager(), "MyDialogFragment"));
    }

    private void initViewLayout() {
        showDialogBtn = (AppCompatButton) findViewById(R.id.show_dialog_btn);
    }
}
