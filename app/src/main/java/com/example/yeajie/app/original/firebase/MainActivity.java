package com.example.yeajie.app.original.firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;

import com.example.yeajie.app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * @author arjen
 */

public class MainActivity extends Activity {
    private AppCompatTextView homePageTxt;
    private AppCompatButton logoutBtn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewLayout();

        auth = FirebaseAuth.getInstance();
        logoutBtn.setOnClickListener(view -> logout());
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        updateUI(user);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            homePageTxt.setText("Home Page");
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    private void initViewLayout() {
        homePageTxt = (AppCompatTextView) findViewById(R.id.home_page_txt);
        logoutBtn = (AppCompatButton) findViewById(R.id.logout_btn);
    }
}
