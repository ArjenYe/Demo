package com.example.yeajie.app.original.autocall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author arjen
 */

public class ActionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AutoDialActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
