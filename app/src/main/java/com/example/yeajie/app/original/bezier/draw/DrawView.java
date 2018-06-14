package com.example.yeajie.app.original.bezier.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * @author arjen
 */

public class DrawView extends View {
    private float preX, preY;
    private Path path = new Path();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = event.getX();
                preY = event.getY();
                path.moveTo(preX, preY);
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (preX + event.getX()) / 2;
                float endY = (preY + event.getY()) / 2;
                path.quadTo(preX, preY, endX, endY);
                preX = event.getX();
                preY = event.getY();
                invalidate();
                break;
            default:
        }
        return super.onTouchEvent(event);
    }

    public void reset() {
        path.reset();
        postInvalidate();
    }
}
