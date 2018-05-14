package com.example.widget.util;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.widget.R;

public class RecyclerViewItemSpace extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public RecyclerViewItemSpace(Context context) {
        this.spanCount = 1;
        this.spacing = context.getResources()
                .getDimensionPixelSize(R.dimen.home_recycler_view_item_space);
        this.includeEdge = false;
    }

    public RecyclerViewItemSpace(Context context, boolean includeEdge) {
        this.spanCount = 1;
        this.spacing = context.getResources()
                .getDimensionPixelSize(R.dimen.home_recycler_view_item_space);
        this.includeEdge = includeEdge;
    }

    public RecyclerViewItemSpace(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;

            if (position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        } else {
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;
            if (position >= spanCount) {
                outRect.top = spacing;
            }
        }
    }
}
