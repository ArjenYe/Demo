package com.example.yeajie.app.original.recyclerview.fetch;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class FetchRecyclerViewHolder extends BaseViewHolder {
    protected LinearLayout rootLayout;
    protected AppCompatTextView numTxt;
    protected AppCompatButton detailBtn;
    protected AppCompatButton closeBtn;

    public FetchRecyclerViewHolder(View view) {
        super(view);
        rootLayout = (LinearLayout) view.findViewById(R.id.root_layout);
        numTxt = (AppCompatTextView) view.findViewById(R.id.num_txt);
        detailBtn = (AppCompatButton) view.findViewById(R.id.detail_btn);
        closeBtn = (AppCompatButton) view.findViewById(R.id.close_btn);
    }

}
