package com.example.yeajie.app.original.autosearch;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arjen
 */

public class AutoSearchActivity extends FragmentActivity {
    private static final long TIME_TRIGGER = 1000;
    private AppCompatEditText queryTextEdit;

    private Handler handler = new Handler();
    private Runnable delayRun = this::toastInputText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_search);
        queryTextEdit = (AppCompatEditText) findViewById(R.id.query_text_edit);

        queryTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (delayRun != null) {
                    handler.removeCallbacks(delayRun);
                }

                if (!TextUtils.isEmpty(queryTextEdit.getText())) {
                    handler.postDelayed(delayRun, TIME_TRIGGER);
                }
            }
        });
    }

    private void toastInputText() {
        Observable.just(queryTextEdit.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> ToastUtil.showToast(getApplicationContext(), s));
    }
}
