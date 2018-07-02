package com.example.yeajie.app.original.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class DialogFragmentActivity extends FragmentActivity {
    private static final int ANIM_NULL = 0;
    private static final int ANIM_TRANSLATE = 1;
    private static final int ANIM_ALPHA = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);

        findViewById(R.id.default_dialog_btn).setOnClickListener(view ->
                getDialog(ANIM_NULL).show(getSupportFragmentManager(), "customerDialog"));
        findViewById(R.id.translate_dialog_btn).setOnClickListener(view ->
                getDialog(ANIM_TRANSLATE).show(getSupportFragmentManager(), "customerDialog"));
        findViewById(R.id.alpha_dialog_btn).setOnClickListener(view ->
                getDialog(ANIM_ALPHA).show(getSupportFragmentManager(), "customerDialog"));
    }

    private CustomDialog getDialog(int anim) {
        switch (anim) {
            case ANIM_TRANSLATE:
                return CustomDialog.newInstance(R.style.dialogBottomStyle, Gravity.BOTTOM);
            case ANIM_ALPHA:
                return CustomDialog.newInstance(R.style.dialogAlphaStyle, Gravity.CENTER);
            default:
                return CustomDialog.newInstance(0, Gravity.CENTER);
        }
    }
}
