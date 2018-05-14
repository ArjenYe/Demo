package com.example.widget.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author whans.
 */
public class ToastUtil {
    // this show be initial in launcher activity
    private static Context activityContext;

    public static void setContext(Context context) {
        activityContext = context;
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showErrorToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showErrorToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }

    public static void showCamieaToast(Context context, String message) {
        showCamieaToast(context, message, 1020);
    }

    public static void showToast(String message) {
        if (activityContext != null) {
            showToast(activityContext, message);
        }
    }

    public static void showErrorToast(String message) {
        if (activityContext != null) {
            showErrorToast(activityContext, message);
        }
    }

    public static void showCamieaToast(Context context, String msg, int yOffset) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, yOffset);
        toast.show();
    }
}
