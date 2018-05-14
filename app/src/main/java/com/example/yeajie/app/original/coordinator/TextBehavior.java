package com.example.yeajie.app.original.coordinator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author arjen
 */

public class TextBehavior extends CoordinatorLayout.Behavior<AppCompatTextView> {
    public TextBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppCompatTextView child, View dependency) {
        return dependency instanceof AppCompatButton;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppCompatTextView child, View dependency) {
        child.setX(dependency.getX() + dependency.getWidth() / 2 - child.getWidth() / 2);
        child.setY(dependency.getY() + dependency.getHeight());
        return true;
    }
}