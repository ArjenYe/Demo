package com.example.yeajie.app.original.firebase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * @author arjen
 */

public class RegisterActivity extends Activity {
    private TextInputEditText emailEdit;
    private TextInputEditText passwordEdit;
    private AppCompatButton registerBtn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViewLayout();

        auth = FirebaseAuth.getInstance();
        registerBtn.setOnClickListener(view -> register());
    }

    private void register() {
        String email = emailEdit.getText().toString();
        if (TextUtils.isEmpty(email)) {
            ToastUtil.showToast(this,"Input email");
            return;
        }

        String password = passwordEdit.getText().toString();
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showToast(this,"Input password");
            return;
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        ToastUtil.showToast(this, "Register success");
                        finish();
                    } else {
                        ToastUtil.showToast(this, "Register fail");
                    }
                });
    }

    private void initViewLayout() {
        emailEdit = (TextInputEditText) findViewById(R.id.email_edit);
        passwordEdit = (TextInputEditText) findViewById(R.id.password_edit);
        registerBtn = (AppCompatButton) findViewById(R.id.register_btn);
    }
}
