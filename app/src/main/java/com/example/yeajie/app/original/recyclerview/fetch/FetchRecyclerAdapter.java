package com.example.yeajie.app.original.recyclerview.fetch;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.platform.recyclerview.FetchItemEntry;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class FetchRecyclerAdapter extends BaseQuickAdapter<FetchItemEntry, FetchRecyclerViewHolder> {
    public FetchRecyclerAdapter() {
        super(R.layout.item_fetch_item, null);
    }

    @Override
    protected void convert(FetchRecyclerViewHolder helper, FetchItemEntry item) {
        helper.setText(R.id.num_txt, String.valueOf(item.getNum()));
        helper.addOnClickListener(R.id.detail_btn);
        helper.addOnClickListener(R.id.close_btn);
    }
}
