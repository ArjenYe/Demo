package com.example.yeajie.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.widget.util.RecyclerViewItemSpace;
import com.jakewharton.rxbinding.view.RxView;
import com.vondear.rxtools.view.popupwindows.tools.RxPopupView;

/**
 * @author arjen
 */

public class HomeActivity extends Activity {
    private LinearLayout originLayout;
    private LinearLayout newLayout;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViewLayout();

        initRecyclerView();
        adapter.setItems(OriginItem.getItems());

        RxView.clicks(originLayout).subscribe(view -> showOriginItem());
        RxView.clicks(newLayout).subscribe(view -> showNewItem());
    }

    private void showNewItem() {
        adapter.setItems(NewItem.getItems());
        originLayout.setBackgroundResource(R.color.gray);
        newLayout.setBackgroundResource(R.color.white);
    }

    private void showOriginItem() {
        adapter.setItems(OriginItem.getItems());
        originLayout.setBackgroundResource(R.color.white);
        newLayout.setBackgroundResource(R.color.gray);
    }

    private void initRecyclerView() {
        adapter = new HomeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerViewItemSpace(this));
        recyclerView.setAdapter(adapter);
    }

    private void initViewLayout() {
        originLayout = (LinearLayout) findViewById(R.id.origin_layout);
        newLayout = (LinearLayout) findViewById(R.id.new_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        newLayout.setBackgroundResource(R.color.gray);
    }
}
