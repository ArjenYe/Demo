package com.example.yeajie.app.original.coordinator.search;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author arjen
 */

public class HeaderScrollingBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    public HeaderScrollingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RecyclerView child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RecyclerView child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
