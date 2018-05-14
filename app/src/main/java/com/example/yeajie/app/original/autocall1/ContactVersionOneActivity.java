package com.example.yeajie.app.original.autocall1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.widget.util.ContactUtil;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class ContactVersionOneActivity extends Activity {

    private RecyclerView recyclerView;
    private ContactVersionOneAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_version_one);
        initViewLayout();

        adapter = new ContactVersionOneAdapter();
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("tel:" + adapter.getItem(position).phone));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        });

        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setNewData(ContactUtil.getContacts(this, false));
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void initViewLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}
