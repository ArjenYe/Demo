package com.example.yeajie.app.original.autocall.test;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.widget.core.OnItemClick;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected AppCompatButton testBtn;
    private OnItemClick onItemClick;

    public TestViewHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        testBtn = itemView.findViewById(R.id.test_btn);
        testBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick.onItemClick(getAdapterPosition());
    }
}
