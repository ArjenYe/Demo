package com.example.yeajie.app.original.autocall.contactlist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.platform.contactlist.ContactEntry;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class ContactListAdapter extends BaseQuickAdapter<ContactEntry, BaseViewHolder> {
    public ContactListAdapter() {
        super(R.layout.item_home_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactEntry item) {
        helper.setImageBitmap(R.id.item_img, item.phoneBitMap)
                .setText(R.id.item_name_txt, item.name + ": " + item.phone);
    }
}
