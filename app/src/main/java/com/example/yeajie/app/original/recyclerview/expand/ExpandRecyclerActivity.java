package com.example.yeajie.app.original.recyclerview.expand;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class ExpandRecyclerActivity extends Activity {
    private RecyclerView recyclerView;
    private ExpandAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new ExpandAdapter(getData());
        adapter.setOnItemChildClickListener((adapter1, view, position) -> {
            if (view.getId() == R.id.root_layout) {
                ToastUtil.showToast(this, ((ExpandSubItem) adapter1.getItem(position)).getSubItemName());
            }

            if (view.getId() == R.id.show_sn_btn) {
                showDetailDialog(((ExpandSubItem) adapter1.getItem(position)).getSnSize());
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showDetailDialog(int snCount) {
        List<String> snList = getSn(snCount);
        new AlertDialog.Builder(this)
                .setTitle("SN List")
                .setItems(snList.toArray(new String[snList.size()]), (dialogInterface, i) -> dialogInterface.dismiss())
                .setPositiveButton("ok", (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }

    private List<String> getSn(int snCount) {
        List<String> snList = new ArrayList<>();
        for (int i = 0; i < snCount; i++) {
            double num = Math.random() * 100000L;
            snList.add((int) num + "");
        }
        return snList;
    }

    private List<MultiItemEntity> getData() {
        int itemCount = 3;
        int subItemCount = 5;

        List<MultiItemEntity> data = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            ExpandItem expandItem = new ExpandItem(i);
            for (int j = 0; j < subItemCount; j++) {
                ExpandSubItem subItem = new ExpandSubItem(j);
                expandItem.addSubItem(subItem);
            }
            data.add(expandItem);
        }
        return data;
    }
}
