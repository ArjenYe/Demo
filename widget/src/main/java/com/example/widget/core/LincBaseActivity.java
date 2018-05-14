package com.example.widget.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * @author whans
 */
public abstract class LincBaseActivity extends AppCompatActivity {
    protected Context appContext;

    protected int activePhotoWidgetId = 0;

    public void setCurtActivePhotoWidget(int widgetId) {
        this.activePhotoWidgetId = widgetId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appContext = getApplicationContext();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void initToolBar(Toolbar toolbar, String title) {
        if (toolbar == null) {
            return;
        }
        toolbar.setTitle(title);
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

    protected void initToolBar(Toolbar toolbar, @StringRes int title) {
        if (toolbar == null) {
            return;
        }
        toolbar.setTitle(title);
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

    public <T extends View> T findView(int viewId) {
        return (T) this.findViewById(viewId);
    }
}
