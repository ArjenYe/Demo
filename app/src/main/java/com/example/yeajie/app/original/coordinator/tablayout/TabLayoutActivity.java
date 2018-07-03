package com.example.yeajie.app.original.coordinator.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.coordinator.toolbar.HideToolbarAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class TabLayoutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    private HideToolbarAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Test for TabLayout");

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab-1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab-2"));

        adapter = new HideToolbarAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setNewData(buildRcvContent());
    }

    private List<String> buildRcvContent() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            stringList.add("Hide toolbar: Item " + i);
        }
        return stringList;
    }
}
