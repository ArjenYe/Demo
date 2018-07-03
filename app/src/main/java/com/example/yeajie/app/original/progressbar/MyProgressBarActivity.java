package com.example.yeajie.app.original.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ProgressBar;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class MyProgressBarActivity extends FragmentActivity {
    private static final String COMPLETED = "Completed";
    private ProgressBar progressBar;
    private AppCompatTextView progressTxt;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.getData().getBoolean(COMPLETED, false)) {
                finish();
            } else {
                progressTxt.setText(msg.what + "%");
            }
        }
    };
    private AppCompatButton startBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress_bar);
        initViewLayout();

        startBtn.setOnClickListener(view -> {
            new ProgressThread().start();
            startBtn.setClickable(false);
        });
    }

    private void initViewLayout() {
        progressBar = findViewById(R.id.progress_bar);
        progressTxt = findViewById(R.id.progress_txt);
        startBtn = findViewById(R.id.start_btn);
    }

    private class ProgressThread extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 0;
            while (i <= 100) {
                progressBar.setProgress(i);
                handler.sendEmptyMessage(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

            Bundle bundle = new Bundle();
            bundle.putBoolean(COMPLETED, true);
            Message message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }
}
