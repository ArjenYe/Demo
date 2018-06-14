package com.example.yeajie.app.original.bezier.wave;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @author arjen
 */

public class WaveView extends View {
    private Path path;
    private Paint paint;
    private ValueAnimator animator;

    private int controlOffset = 60;
    private int width = 720;
    private int height = 1184;
    private int levelY = height / 4 * 3;
    private int moveToWidth = 0;
    private int moveToHeight = 0;
    private boolean waveUp = true;

    private int[] startPoint = {-width, levelY};
    private int[] control_1 = {-width / 4 * 3, levelY - controlOffset};
    private int[] point1 = {-width / 2, levelY};
    private int[] control_2 = {-width / 4, levelY + controlOffset};
    private int[] point2 = {0, levelY};
    private int[] control_3 = {width / 4, levelY - controlOffset};
    private int[] point3 = {width / 2, levelY};
    private int[] control_4 = {width / 4 * 3, levelY + controlOffset};
    private int[] point4 = {width, levelY};

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path.moveTo(startPoint[0] + moveToWidth, levelY + moveToHeight);

        path.quadTo(control_1[0] + moveToWidth, control_1[1] + moveToHeight, point1[0] + moveToWidth, point1[1] + moveToHeight);
        path.quadTo(control_2[0] + moveToWidth, control_2[1] + moveToHeight, point2[0] + moveToWidth, point2[1] + moveToHeight);
        path.quadTo(control_3[0] + moveToWidth, control_3[1] + moveToHeight, point3[0] + moveToWidth, point3[1] + moveToHeight);
        path.quadTo(control_4[0] + moveToWidth, control_4[1] + moveToHeight, point4[0] + moveToWidth, point4[1] + moveToHeight);

        path.lineTo(width, height);
        path.lineTo(-width, height);
        path.lineTo(-width, height / 2);
        canvas.drawPath(path, paint);

    }

    public void startAnim() {
        animator = ValueAnimator.ofInt(0, width);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(animation -> {
            moveToWidth = (int) animation.getAnimatedValue();
            if (moveToHeight == 0) {
                waveUp = true;
            }

            if (moveToHeight == -800) {
                waveUp = false;
            }

            if (waveUp) {
                moveToHeight = moveToHeight - 2;
            } else {
                moveToHeight = moveToHeight + 2;
            }

            invalidate();
        });
        animator.start();
    }

    public void cancelAnim() {
        if (animator != null) {
            animator.cancel();
        }
    }
}
