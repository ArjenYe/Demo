package com.example.yeajie.app.original.mytextview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class MyTextViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_view);
        MyTextView myTextView = findViewById(R.id.my_text_txt);
        myTextView.setOnClickListener(view -> ToastUtil.showToast(this, "Text click."));
    }
}
