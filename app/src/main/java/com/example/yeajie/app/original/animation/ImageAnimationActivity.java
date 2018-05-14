package com.example.yeajie.app.original.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.http.HttpRequestActivity;

/**
 * @author arjen
 */

public class ImageAnimationActivity extends Activity {
    private AppCompatImageView footprint1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_anim);
        footprint1 = (AppCompatImageView) findViewById(R.id.footprint_1);

        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_footprint_1);
        footprint1.startAnimation(animationSet);

        footprint1.setOnClickListener(view -> startActivity(new Intent(this, HttpRequestActivity.class)));
    }
}
