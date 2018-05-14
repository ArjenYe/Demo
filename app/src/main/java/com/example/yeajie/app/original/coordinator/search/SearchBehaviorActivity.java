package com.example.yeajie.app.original.coordinator.search;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class SearchBehaviorActivity extends Activity {
    private AppCompatImageView headerImg;
    private LinearLayout searchLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_behavior);
        initViewLayout();



    }

    private void initViewLayout() {
        headerImg = (AppCompatImageView) findViewById(R.id.header_img);
        searchLayout = (LinearLayout) findViewById(R.id.search_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }
}
