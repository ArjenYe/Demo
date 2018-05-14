package com.example.yeajie.app.original.recyclerview.fetch;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.platform.recyclerview.FetchItemEntry;
import com.example.yeajie.app.R;
import com.example.widget.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class FetchRecyclerActivity extends Activity {
    private RecyclerView recyclerView;

    private FetchRecyclerAdapter adapter;

    private int count = 0;
    private int eachFetchCount = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new FetchRecyclerAdapter();
        initRecyclerView();
        initFetchAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setNewData(getFetchData(eachFetchCount));
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initFetchAdapter() {
        adapter.bindToRecyclerView(recyclerView);
        adapter.disableLoadMoreIfNotFullPage();
        adapter.setLoadMoreView(new CustomLoadMoreView());

        adapter.setOnItemChildClickListener((adapter12, view, position) -> {
            if (view.getId() == R.id.detail_btn) {
                showDetailToast(position);
            } else if (view.getId() == R.id.close_btn) {
                showCloseToast(position);
            }
        });

        adapter.setOnItemClickListener((adapter1, view, position) ->
                ToastUtil.showToast(this, String.valueOf(adapter.getItem(position).getNum())));

        adapter.setOnLoadMoreListener(this::startFetch, recyclerView);
    }

    private void showCloseToast(int position) {
        ToastUtil.showToast(this, "Close: " + adapter.getItem(position).getNum());
    }

    private void showDetailToast(int position) {
        ToastUtil.showToast(this, "Detail: " + adapter.getItem(position).getNum());
    }

    private void startFetch() {
        count += eachFetchCount;
        recyclerView.postDelayed(() -> {
            if (adapter.getItemCount() >= 30) {
                adapter.loadMoreEnd(true);
            } else {
                adapter.addData(adapter.getItemCount() - 1, getFetchData(eachFetchCount));
                adapter.loadMoreComplete();
            }
        }, 500);
    }

    public List<FetchItemEntry> getFetchData(int record) {
        List<FetchItemEntry> fetchItemEntries = new ArrayList<>();
        for (int i = 1; i <= record; i++) {
            fetchItemEntries.add(new FetchItemEntry(count + i));
        }
        return fetchItemEntries;
    }
}
