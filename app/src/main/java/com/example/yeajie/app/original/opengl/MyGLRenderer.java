package com.example.yeajie.app.original.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author arjen
 */

public class MyGLRenderer implements GLSurfaceView.Renderer {

    /**
     * onSurfaceCreated()：调用一次，用来配置View的OpenGL ES环境。
     * onDrawFrame()：每次重新绘制View时被调用。
     * onSurfaceChanged()：如果View的几何形态发生变化时会被调用，例如当设备的屏幕方向发生改变时
     */

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        // Set the background frame color
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }
}
