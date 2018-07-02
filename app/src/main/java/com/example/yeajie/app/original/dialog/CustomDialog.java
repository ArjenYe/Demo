package com.example.yeajie.app.original.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class CustomDialog extends DialogFragment {
    private static final String ANIM_RES_ID = "Anim res id";
    private static final String GRAVITY = "Gravity";

    public static CustomDialog newInstance(@StyleRes int resId, int gravity) {
        CustomDialog dialog = new CustomDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(GRAVITY, gravity);
        bundle.putInt(ANIM_RES_ID, resId);
        dialog.setArguments(bundle);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.view_custom_dialog, null);
        return new AlertDialog.Builder(getActivity()).setView(view).create();
    }

    @Override
    public void onStart() {
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            //设置透明背景
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置宽度、高度、位置
            WindowManager.LayoutParams params = window.getAttributes();
            window.getDecorView().setPadding(0, 0, 0, 0);
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.gravity = getArguments().getInt(GRAVITY);
            //设置动画
            window.setWindowAnimations(getArguments().getInt(ANIM_RES_ID));
        }
        super.onStart();
    }
}