package com.example.yeajie.app.original.coordinator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class CoordinatorBehaviorActivity extends Activity {
    private float offSetX;
    private float offSetY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_behavior);

        AppCompatButton moveBtn = (AppCompatButton) findViewById(R.id.move_btn);
        moveBtn.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    offSetX = motionEvent.getRawX() - view.getX();
                    offSetY = motionEvent.getRawY() - view.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.setX(motionEvent.getRawX() - offSetX);
                    view.setY(motionEvent.getRawY() - offSetY);
                    break;
                default:
            }
            return false;
        });
    }
}
