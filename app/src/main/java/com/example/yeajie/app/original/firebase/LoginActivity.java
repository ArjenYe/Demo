package com.example.yeajie.app.original.firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * @author arjen
 */

public class LoginActivity extends Activity {
    private TextInputEditText emailEdit;
    private TextInputEditText passwordEdit;
    private AppCompatButton loginBtn;
    private AppCompatTextView registerTxt;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViewLayout();

        auth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(view -> login());
        registerTxt.setOnClickListener(view -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    private void login() {
        String email = emailEdit.getText().toString();
        if (TextUtils.isEmpty(email)) {
            ToastUtil.showToast(this, "Input email");
            return;
        }

        String password = passwordEdit.getText().toString();
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showToast(this, "Input password");
            return;
        }

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        ToastUtil.showToast(this, "Login success");
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        ToastUtil.showToast(this, task.getException().getMessage());
                    }
                });
    }

    private void initViewLayout() {
        emailEdit = findViewById(R.id.email_edit);
        passwordEdit = findViewById(R.id.password_edit);
        loginBtn = findViewById(R.id.login_btn);
        registerTxt = findViewById(R.id.register_txt);
    }
}
