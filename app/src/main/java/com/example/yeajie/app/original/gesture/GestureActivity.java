package com.example.yeajie.app.original.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class GestureActivity extends Activity {
    private AppCompatTextView gestureTxt;
    private AppCompatTextView positionTxt;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        gestureTxt = (AppCompatTextView) findViewById(R.id.gesture_txt);
        positionTxt = (AppCompatTextView) findViewById(R.id.position_txt);

        gestureDetector = new GestureDetector(this, new GestureTest());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureTest implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            gestureTxt.setText("Press Down");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            gestureTxt.setText("Show Press");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            gestureTxt.setText("Single Tap Up");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            gestureTxt.setText("Scroll");

            positionTxt.setText("e1: " + e1.getX() + ", " + e1.getY() + "\n"
                    + "e2: " + e2.getX() + ", " + e2.getY());

            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            gestureTxt.setText("Long Press");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            gestureTxt.setText("Fling");
            return true;
        }
    }
}
