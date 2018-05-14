package com.example.yeajie.app.original.recyclerview.expand;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class SnAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SnAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.sn_txt, item);
    }
}
