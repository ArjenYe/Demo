package com.example.yeajie.app.original.autocall.recyclercall;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yeajie.app.R;
import com.example.widget.core.OnItemClick;

/**
 * @author arjen
 */

public class RecyclerDialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected LinearLayout contactItemLayout;
    protected AppCompatImageView contactImg;
    protected AppCompatTextView contactTxt;
    protected AppCompatTextView phoneNumTxt;
    private OnItemClick onItemClick;

    public RecyclerDialViewHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        contactItemLayout = (LinearLayout) itemView.findViewById(R.id.contact_item_layout);
        contactImg = (AppCompatImageView) itemView.findViewById(R.id.contact_img);
        contactTxt = (AppCompatTextView) itemView.findViewById(R.id.contact_txt);
        phoneNumTxt = (AppCompatTextView) itemView.findViewById(R.id.phone_num_txt);

        contactItemLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick.onItemClick(getAdapterPosition());
    }
}
