package com.example.yeajie.app.original.opengl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author arjen
 */

public class OpenGlActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyGLSurfaceView surfaceView = new MyGLSurfaceView(this);
        setContentView(surfaceView);
    }
}
