package com.example.yeajie.app;

import android.app.Application;
import android.os.StrictMode;

import com.example.platform.http.HttpService;
import com.example.widget.util.Utils;
import com.facebook.stetho.Stetho;
import com.google.firebase.FirebaseApp;
import com.vondear.rxtools.RxTool;

import org.litepal.LitePal;

/**
 * @author arjen
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        Stetho.initializeWithDefaults(this);

        Utils.init(this);
        RxTool.init(this);
        LitePal.initialize(this);

        HttpService.init();
        FirebaseApp.initializeApp(getApplicationContext());
    }
}
