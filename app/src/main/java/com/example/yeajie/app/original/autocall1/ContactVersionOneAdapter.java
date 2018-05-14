package com.example.yeajie.app.original.autocall1;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.platform.contactlist.ContactEntry;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class ContactVersionOneAdapter extends BaseQuickAdapter<ContactEntry, BaseViewHolder> {

    public ContactVersionOneAdapter() {
        super(R.layout.item_contact_version_one);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactEntry item) {
        helper.setImageBitmap(R.id.contact_img, item.phoneBitMap);
    }
}
