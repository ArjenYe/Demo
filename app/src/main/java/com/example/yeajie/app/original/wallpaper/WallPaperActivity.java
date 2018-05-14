package com.example.yeajie.app.original.wallpaper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;

import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class WallPaperActivity extends Activity {
    private AppCompatButton selectWallPaperBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        selectWallPaperBtn = (AppCompatButton) findViewById(R.id.select_wall_paper_btn);
        selectWallPaperBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
            startActivity(Intent.createChooser(intent, "ChooseWallPaper"));
        });

    }
}
