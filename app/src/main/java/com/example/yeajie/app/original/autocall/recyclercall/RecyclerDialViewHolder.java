package com.example.yeajie.app.original.autocall.recyclercall;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.widget.core.OnItemClick;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class RecyclerDialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected LinearLayout contactItemLayout;
    protected AppCompatImageView contactImg;
    protected AppCompatTextView contactTxt;
    protected AppCompatTextView phoneNumTxt;
    protected AppCompatImageView deleteContactImg;
    private OnItemClick onItemClick;

    public RecyclerDialViewHolder(View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        contactItemLayout = itemView.findViewById(R.id.contact_item_layout);
        contactImg = itemView.findViewById(R.id.contact_img);
        contactTxt = itemView.findViewById(R.id.contact_txt);
        phoneNumTxt = itemView.findViewById(R.id.phone_num_txt);
        deleteContactImg = itemView.findViewById(R.id.delete_contact_img);

        contactItemLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onItemClick.onItemClick(getAdapterPosition());
    }
}
