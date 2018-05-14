package com.example.yeajie.app.original.autocall.inxml;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yeajie.app.R;
import com.example.widget.core.LincBaseFragment;

/**
 * @author arjen
 */

public class HardCodeFragment extends LincBaseFragment {
    private LinearLayout arjenItemLayout;
    private TextView arjenNumTxt;
    private String phoneNum;

    public static HardCodeFragment newInstance() {
        return new HardCodeFragment();
    }

    @Override
    protected void initView() {
        arjenItemLayout = findViewById(R.id.arjen_item_layout);
        arjenNumTxt = findViewById(R.id.arjen_num_txt);

        arjenItemLayout.setOnClickListener(view -> callArjen());
    }

    private void callArjen() {
        phoneNum = arjenNumTxt.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + phoneNum));
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hard_code;
    }
}
