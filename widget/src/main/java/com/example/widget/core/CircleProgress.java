package com.example.widget.core;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.widget.R;


/**
 * @author whans.
 */
public class CircleProgress extends Dialog implements NetworkProgressView {
    private int showCounter = 0;

    public CircleProgress(Context context) {
        super(context);
    }

    public CircleProgress(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static CircleProgress create(Context context) {
        return create(context, 0);
    }

    public static CircleProgress create(Context context, int stringResId) {
        CircleProgress circleProgress = new CircleProgress(context.getApplicationContext(),
                R.style.circleProgressTheme);
        circleProgress.setContentView(R.layout.widget_circle_progress);
        if (circleProgress.getWindow() != null) {
            circleProgress.getWindow().getAttributes().gravity = Gravity.CENTER;
            circleProgress.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        }
        if (stringResId > 0) {
            TextView message = (TextView) circleProgress.findViewById(R.id.circle_progress_txt);
            message.setText(context.getString(stringResId));
        }

        return circleProgress;
    }

    @Override
    public void show() {
        if (this.getWindow() == null) {
            return;
        }

        super.show();
    }

    @Override
    public synchronized void showProgress(boolean show) {
        if (show) {
            showCounter++;
        } else {
            showCounter--;
        }

        if (showCounter == 0) {
            super.dismiss();
        } else {
            if (!isShowing()) {
                super.show();
            }
        }
    }

    @Override
    public void touchCancelable(boolean cancelable) {
        setCancelable(cancelable);
    }
}
