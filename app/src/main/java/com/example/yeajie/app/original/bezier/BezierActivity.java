package com.example.yeajie.app.original.bezier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;

import com.example.yeajie.app.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arjen
 */

public class BezierActivity extends Activity {
    int startX;
    int startY;
    int controlX1;
    int controlY1;
    int endX;
    int endY;
    int start_X;
    int start_Y;
    int end_X;
    int end_Y;
    int control_X1;
    int control_Y1;
    int control_X2;
    int control_Y2;
    private AppCompatImageView img;
    private AppCompatImageView img1;
    private AppCompatImageView img2;
    private double i = 0;
    private Subscription subscribe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        img = (AppCompatImageView) findViewById(R.id.img);
        img1 = (AppCompatImageView) findViewById(R.id.img_1);
        img2 = (AppCompatImageView) findViewById(R.id.img_2);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        startX = 0;
        startY = 0;
        controlX1 = 0;
        controlY1 = height;
        endX = width;
        endY = 0;

        start_X = 0;
        start_Y = height / 2;
        control_X1 = width / 4;
        control_Y1 = 0;
        control_X2 = width / 4 * 3;
        control_Y2 = height;
        end_X = width - 20;
        end_Y = height / 2;

        img.setX(0);
        img1.setX(0);
        img2.setX(0);
        img.setY(height / 2);
        img1.setY(height / 2);
        img2.setY(height / 2);

        subscribe = Observable.interval(20, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        if (i == 100 && subscribe != null && !subscribe.isUnsubscribed()) {
                            subscribe.unsubscribe();
                            return;
                        }

                        img.setX(get_X());
                        img.setY(get_Y());

                        img1.setX(getX());
                        img1.setY(getY());

                        img2.setX(get_X());
                        img2.setY(get_Y() + 40);

                        i++;
                    }
                });
    }

    //三阶贝塞尔
    public int get_X() {
        double t = i / 100;
        double xPosition
                = (1 - t) * (1 - t) * (1 - t) * start_X
                + 3 * control_X1 * t * (1 - t) * (1 - t)
                + 3 * control_X2 * t * (1 - t) * (1 - t)
                + t * t * t * end_X;
        return (int) xPosition;
    }

    public int get_Y() {
        double t = i / 100;
        double yPosition
                = (1 - t) * (1 - t) * (1 - t) * start_Y
                + 3 * control_Y1 * t * (1 - t) * (1 - t)
                + 3 * control_Y2 * t * (1 - t) * (1 - t)
                + t * t * t * end_Y;
        return (int) yPosition;
    }

    //二阶贝塞尔
    public int getX() {
        double t = i / 100;
        return (int) ((1 - t) * (1 - t) * startX + 2 * t * (1 - t) * controlX1 + t * t * endX);
    }

    public int getY() {
        double t = i / 100;
        return (int) ((1 - t) * (1 - t) * startY + 2 * t * (1 - t) * controlY1 + t * t * endY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe != null && !subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
        }
    }
}
