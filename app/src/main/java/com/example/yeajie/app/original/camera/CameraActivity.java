package com.example.yeajie.app.original.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;

import com.example.yeajie.app.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author arjen
 */

public class CameraActivity extends Activity {
    private static final int CAPTURE_REQUEST_CODE = 0;
    private static final int TAKE_PHOTO_REQUEST_CODE = 1;
    private static final String PHOTO_SUFFIX = ".jpg";

    private Toolbar toolbar;
    private AppCompatImageView pictureImg;
    private AppCompatButton captureBtn;
    private AppCompatButton takePhotoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initViewLayout();

        toolbar.setTitle(R.string.text_capture);
        captureBtn.setOnClickListener(view -> startCapture());
        takePhotoBtn.setOnClickListener(view -> startTakePhoto());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (CAPTURE_REQUEST_CODE == requestCode && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap pictureBitmap = (Bitmap) extras.get("data");
            pictureImg.setImageBitmap(pictureBitmap);
        }
    }

    private void startTakePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File file = null;
            try {
                file = createPhotoFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);
            }
        }
    }

    private void startCapture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAPTURE_REQUEST_CODE);
        }
    }

    private void initViewLayout() {
        toolbar = findViewById(R.id.tool_bar);
        pictureImg = findViewById(R.id.picture_img);
        captureBtn = findViewById(R.id.capture_btn);
        takePhotoBtn = findViewById(R.id.take_photo_btn);
    }

    private File createPhotoFile() throws IOException {
        String photoName = SimpleDateFormat.getDateInstance().format(new Date());
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(photoName, PHOTO_SUFFIX, storageDir);
    }
}
