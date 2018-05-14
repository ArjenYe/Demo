package com.example.yeajie.app.original.vibrator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;

/**
 * @author arjen
 */

public class VibratorActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        RxView.clicks(findViewById(R.id.start_btn)).subscribe(view ->
                vibrator.vibrate(new long[]{500, 100, 500, 100}, 0));

        RxView.clicks(findViewById(R.id.stop_btn)).subscribe(view ->
                vibrator.cancel());
    }
}
