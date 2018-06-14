package com.example.yeajie.app.original.bezier.wave;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;

/**
 * @author arjen
 */

public class WaveActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);

        WaveView waveView = (WaveView) findViewById(R.id.wave_view);
        RxView.clicks(findViewById(R.id.start_btn)).subscribe(view -> waveView.startAnim());
        RxView.clicks(findViewById(R.id.stop_btn)).subscribe(view -> waveView.cancelAnim());
    }
}
