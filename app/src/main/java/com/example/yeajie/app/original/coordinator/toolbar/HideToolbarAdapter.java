package com.example.yeajie.app.original.coordinator.toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class HideToolbarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public HideToolbarAdapter() {
        super(R.layout.item_general_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.content_txt, item);
    }
}
