package com.example.yeajie.app.original.speechtotext;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author arjen
 */

public class SpeechToTextActivity extends FragmentActivity {
    private static final int VTT_REQUEST_CODE = 100;
    private AppCompatButton speechBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        speechBtn = findViewById(R.id.speech_btn);
        speechBtn.setOnClickListener(view -> doSpeech());
    }

    private void doSpeech() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
        try {
            startActivityForResult(intent, VTT_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            ToastUtil.showToast(this, "Device not support speech input");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case VTT_REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    ToastUtil.showToast(this, result.get(0));
                }
                break;
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
