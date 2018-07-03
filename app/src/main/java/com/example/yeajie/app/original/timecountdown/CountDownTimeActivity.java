package com.example.yeajie.app.original.timecountdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;

import com.example.yeajie.app.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arjen
 */

public class CountDownTimeActivity extends FragmentActivity {
    private AppCompatButton getCodeBtn;
    private Subscription subscribe;
    private AppCompatTextView timerTxt;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_time);
        timerTxt = findViewById(R.id.timer_txt);

        MyCountDown myCountDown = new MyCountDown(60 * 1000, 1000);
        getCodeBtn = findViewById(R.id.btn_get_code);
        getCodeBtn.setOnClickListener(view -> {
            getCodeBtn.setClickable(false);
            myCountDown.start();
            stopTimer();
            i = 0;
        });

        subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        timerTxt.setText(String.valueOf(++i));
                    }
                });
    }

    private void stopTimer() {
        if (subscribe != null && !subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
        }
    }

    private class MyCountDown extends CountDownTimer {

        MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            getCodeBtn.setText(l / 1000 + "秒");
        }

        @Override
        public void onFinish() {
            getCodeBtn.setClickable(true);
            getCodeBtn.setText("重新获取");
        }
    }
}
