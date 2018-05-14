package com.example.yeajie.app.original.configuration;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;

/**
 * @author arjen
 */

public class ConfigurationActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Configuration configuration = getResources().getConfiguration();

        RxView.clicks(findViewById(R.id.orientation_btn)).subscribe(view -> {
            switch (configuration.orientation) {
                case Configuration.ORIENTATION_LANDSCAPE:
                    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    break;
                case Configuration.ORIENTATION_PORTRAIT:
                    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    break;
                default:
            }
        });
    }
}
