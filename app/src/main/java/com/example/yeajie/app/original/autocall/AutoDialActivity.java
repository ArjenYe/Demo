package com.example.yeajie.app.original.autocall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.autocall.recyclercall.RecyclerFragment;
import com.vondear.rxtools.RxDeviceTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arjen
 */

public class AutoDialActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_dial);
        final List<HashMap<String, String>> allContactInfo = RxDeviceTool.getAllContactInfo(this);
        if (allContactInfo != null && allContactInfo.size() > 0) {
            for (HashMap<String, String> stringStringHashMap : allContactInfo) {
                for (Map.Entry<String, String> stringStringEntry : stringStringHashMap.entrySet()) {
                    System.out.println("======== Key:" + stringStringEntry.getKey() + " Value:" + stringStringEntry.getValue());
                }
            }
        }

/*
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, TestFragment.newInstance())
                .commit();
*/

        //in db
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, RecyclerFragment.newInstance())
                .commit();

/*        //hard code
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, HardCodeFragment.newInstance())
                .commit();*/
    }
}
