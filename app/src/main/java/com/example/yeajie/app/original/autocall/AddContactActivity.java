package com.example.yeajie.app.original.autocall;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.example.platform.local.DialEntity;
import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class AddContactActivity extends Activity {
    private AppCompatEditText nameEdt;
    private AppCompatEditText phoneNumEdt;
    private LinearLayout contactAddLayout;
    private LinearLayout successLayout;
    private AppCompatButton returnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        nameEdt = findViewById(R.id.name_edt);
        phoneNumEdt = findViewById(R.id.phone_num_edt);
        contactAddLayout = findViewById(R.id.contact_add_layout);
        successLayout = findViewById(R.id.success_layout);
        returnBtn = findViewById(R.id.return_btn);

        contactAddLayout.setVisibility(View.VISIBLE);
        successLayout.setVisibility(View.GONE);

        AppCompatButton okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(view -> onAddBtnClick());
        returnBtn.setOnClickListener(view -> finish());
    }

    private void onAddBtnClick() {
        String name = nameEdt.getText().toString();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast("Input name");
            return;
        }

        String phoneNum = phoneNumEdt.getText().toString();
        if (TextUtils.isEmpty(phoneNum)) {
            ToastUtil.showToast("Input num");
            return;
        }

        DialEntity dialEntity = new DialEntity();
        dialEntity.setContact(name);
        dialEntity.setPhoneNum(phoneNum);
        dialEntity.save();

        contactAddLayout.setVisibility(View.GONE);
        successLayout.setVisibility(View.VISIBLE);
    }
}
