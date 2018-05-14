package com.example.yeajie.app.original.http;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author arjen
 */

public class OkHttpActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("").build();

        //异步enqueue
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
