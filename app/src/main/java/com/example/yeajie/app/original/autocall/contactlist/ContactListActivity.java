package com.example.yeajie.app.original.autocall.contactlist;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.widget.util.ContactUtil;
import com.example.widget.util.RecyclerViewItemSpace;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class ContactListActivity extends Activity {
    //获取库Phon表字段
    private static final String[] PHONES_PROJECTION = new String[]{
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Photo.PHOTO_ID,
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
            ContactsContract.CommonDataKinds.Phone.NUMBER};
    // 联系人显示名称
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    //电话号码
    private static final int PHONES_NUMBER_INDEX = 1;
    //头像ID
    private static final int PHONES_PHOTO_ID_INDEX = 2;
    //联系人的ID
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    private RecyclerView recyclerView;
    private ContactListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initViewLayout();

        adapter = new ContactListAdapter();
        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setNewData(ContactUtil.getContacts(this));
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerViewItemSpace(this));
        recyclerView.setAdapter(adapter);
    }

    private void initViewLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}