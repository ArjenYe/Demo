package com.example.yeajie.app.original.animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;

import com.airbnb.lottie.LottieAnimationView;
import com.example.widget.util.ToastUtils;
import com.example.yeajie.app.R;

import java.util.Arrays;
import java.util.List;

/**
 * @author arjen
 */

public class JsonAnimationActivity extends Activity {
    private int animationIndex = 0;
    private LottieAnimationView animationView;
    private List<String> jsonFileName = Arrays.asList("logo.json", "data.json", "hello_world.json");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animationView = findViewById(R.id.animation_view);

        AppCompatButton nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(view -> {
            animationIndex++;
            animationView.setAnimation(jsonFileName.get(animationIndex % 3));
            animationView.playAnimation();
            ToastUtils.showShort("Animation~~~~~~~");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        animationView.setAnimation(jsonFileName.get(animationIndex % 3));
        animationView.loop(true);
        animationView.playAnimation();
        ToastUtils.showShort("Animation~~~~~~~");
    }
}
