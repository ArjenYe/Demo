package com.example.yeajie.app.original.bezier.draw;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;

/**
 * @author arjen
 */

public class DrawBoardActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_board);

        DrawView drawView = (DrawView) findViewById(R.id.draw_view);
        RxView.clicks(findViewById(R.id.reset_btn)).subscribe(view -> drawView.reset());
    }
}
