package com.example.yeajie.app.original.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class ShakeAnimationActivity extends FragmentActivity {
    private static final String ALPHA = "alpha";
    private static final String TRANSLATION_X = "translationX";
    private static final String TRANSLATION_Y = "translationY";
    private static final String SCALE_X = "scaleX";
    private static final String SCALE_Y = "scaleY";
    private static final String ROTATION_X = "rotationX";
    private static final String ROTATION_Y = "rotationY";
    private static final String ROTATION = "rotation";
    private AppCompatImageView pictureImg;
    private AppCompatButton shakeBtn;
    private AppCompatButton scaleBtn;
    private AppCompatButton alphaBtn;
    private AppCompatButton rotateBtn;
    private AppCompatButton allBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_animation);
        initViewLayout();

        shakeBtn.setOnClickListener(view -> pictureImg.startAnimation(shakeAnimation(5)));
        scaleBtn.setOnClickListener(view -> pictureImg.startAnimation(scaleAnimation()));
        alphaBtn.setOnClickListener(view -> pictureImg.startAnimation(alphAnimation()));
        rotateBtn.setOnClickListener(view -> pictureImg.startAnimation(rotateAnimation()));
        allBtn.setOnClickListener(view -> playAll());
    }

    private void playAll() {
        AnimatorSet translationSet = new AnimatorSet();
        Animator translationX = ObjectAnimator.ofFloat(pictureImg, TRANSLATION_X, 0f, 10f).setDuration(2000);
        Animator translationY = ObjectAnimator.ofFloat(pictureImg, TRANSLATION_Y, 0f, 10f).setDuration(2000);
        translationX.setInterpolator(new CycleInterpolator(5));
        translationY.setInterpolator(new CycleInterpolator(5));
        translationSet.play(translationX).with(translationY);

        AnimatorSet animatorSet = new AnimatorSet();

        Animator alpha = ObjectAnimator.ofFloat(pictureImg, ALPHA, 1f, 0f).setDuration(2000);
        Animator scaleX = ObjectAnimator.ofFloat(pictureImg, SCALE_X, 1f, 0.5f).setDuration(2000);
        Animator scaleY = ObjectAnimator.ofFloat(pictureImg, SCALE_Y, 1f, 0.5f).setDuration(2000);
        Animator rotation = ObjectAnimator.ofFloat(pictureImg, ROTATION, 0f, 360f).setDuration(2000);

        animatorSet.play(alpha).with(scaleX).with(scaleY).with(rotation).after(translationSet);
        animatorSet.start();
    }

    //旋转
    private Animation rotateAnimation() {
        Animation animation = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(2000);
        return animation;
    }

    //渐变
    private Animation alphAnimation() {
        Animation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        return animation;
    }

    //平移
    private Animation shakeAnimation(int cycleTimes) {
        Animation animation = new TranslateAnimation(0, 10, 0, 10);
        animation.setInterpolator(new CycleInterpolator(cycleTimes));
        animation.setDuration(1000);
        return animation;
    }

    //缩放
    private Animation scaleAnimation() {
        Animation animation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        return animation;
    }

    private void initViewLayout() {
        pictureImg = (AppCompatImageView) findViewById(R.id.picture_img);
        shakeBtn = (AppCompatButton) findViewById(R.id.shake_btn);
        scaleBtn = (AppCompatButton) findViewById(R.id.scale_btn);
        alphaBtn = (AppCompatButton) findViewById(R.id.alpha_btn);
        rotateBtn = (AppCompatButton) findViewById(R.id.rotate_btn);
        allBtn = (AppCompatButton) findViewById(R.id.all_btn);
    }
}
