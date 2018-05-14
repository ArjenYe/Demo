package com.example.yeajie.app;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class HomeViewHolder extends RecyclerView.ViewHolder {
    protected LinearLayout itemLayout;
    protected AppCompatTextView itemNameTxt;
    protected AppCompatImageView itemImg;

    public HomeViewHolder(View itemView) {
        super(itemView);
        itemLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        itemNameTxt = (AppCompatTextView) itemView.findViewById(R.id.item_name_txt);
        itemImg = (AppCompatImageView) itemView.findViewById(R.id.item_img);
    }
}
