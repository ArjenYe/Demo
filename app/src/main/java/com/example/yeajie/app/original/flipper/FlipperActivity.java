package com.example.yeajie.app.original.flipper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class FlipperActivity extends Activity {
    private ViewFlipper viewFlipper;
    private Context context;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);
        context = this;
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);

        gestureDetector = new GestureDetector(this, new GestureListener());

        //=============================auto===================================
        //viewFlipper.startFlipping();
        //=============================auto===================================
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > 200) {
                viewFlipper.setOutAnimation(context, R.anim.anim_left_out);
                viewFlipper.setInAnimation(context, R.anim.anim_right_in);
                viewFlipper.showNext();
            } else if (e2.getX() - e1.getX() > 200) {
                viewFlipper.setOutAnimation(context, R.anim.anim_right_out);
                viewFlipper.setInAnimation(context, R.anim.anim_left_in);
                viewFlipper.showPrevious();
            }

            return true;
        }

    }
}
