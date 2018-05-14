package com.example.yeajie.app.original.mediarecorder;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;

import java.io.File;
import java.io.IOException;

/**
 * @author arjen
 */

public class MediaRecorderActivity extends Activity {
    private MediaRecorder mediaRecorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_recorder);

        RxView.clicks(findViewById(R.id.start_btn)).subscribe(view -> startRecorder());
        RxView.clicks(findViewById(R.id.stop_btn)).subscribe(view -> stopRecorder());
    }

    private void startRecorder() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
        mediaRecorder.setOutputFile(getFilePath());

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFilePath() {
        File dir = new File(Environment.getExternalStorageDirectory(), "sounds");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, System.currentTimeMillis() + ".amr");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

    private void stopRecorder() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }
}
