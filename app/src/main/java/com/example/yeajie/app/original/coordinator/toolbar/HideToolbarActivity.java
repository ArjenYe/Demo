package com.example.yeajie.app.original.coordinator.toolbar;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yeajie.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class HideToolbarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView recyclerView;

    private HideToolbarAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hide_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Drawable icon = item.getIcon();
        if (icon instanceof Animatable) {
            ((Animatable) icon).start();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        collapsingToolbarLayout.setTitle("Hide");
        adapter = new HideToolbarAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view, position) ->
                Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show());
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

    private void initToolBar() {
        if (toolbar == null) {
            return;
        }
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> {
            if (v != null && v.isPressed()) {
                onBackPressed();
            }
        });
    }
}
