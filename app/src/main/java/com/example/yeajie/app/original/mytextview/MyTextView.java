package com.example.yeajie.app.original.mytextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class MyTextView extends View {
    private String text;
    private int textColor;
    private int textSize = 16;

    private Rect rect;
    private Paint paint;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);

        TypedArray typedArr = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, defaultStyle, 0);

        for (int i = 0; i < typedArr.getIndexCount(); i++) {

            int typeIndex = typedArr.getIndex(i);
            switch (typeIndex) {
                case R.styleable.MyTextView_text:
                    text = typedArr.getString(typeIndex);
                    break;
                case R.styleable.MyTextView_textColor:
                    textColor = typedArr.getColor(typeIndex, Color.BLACK);
                    break;
                case R.styleable.MyTextView_textSize:
                    textSize = typedArr.getDimensionPixelSize(typeIndex, 16);
                    break;
                default:
            }
        }
        typedArr.recycle();

        rect = new Rect();
        paint = new Paint();

        paint.setTextSize(textSize);
        paint.getTextBounds(text, 0, text.length(), rect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            paint.setTextSize(textSize);
            paint.getTextBounds(text, 0, text.length(), rect);
            width = getPaddingLeft() + rect.width() + getPaddingRight();
        }

        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            paint.setTextSize(textSize);
            paint.getTextBounds(text, 0, text.length(), rect);
            height = getPaddingTop() + rect.height() + getPaddingBottom();
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GREEN);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

        paint.setColor(textColor);
        canvas.drawText(text, getWidth() / 2 - rect.width() / 2, getHeight() / 2 - rect.height() / 2, paint);
    }
}
