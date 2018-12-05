package com.example.yeajie.app.original.autocall;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;

import com.example.platform.local.DialEntity;
import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author arjen
 */

public class AddContactActivity extends Activity {
    private static final int TAKE_PHOTO_REQUEST_CODE = 0;
    private static final String PHOTO_SUFFIX = ".jpg";
    private AppCompatEditText nameEdt;
    private AppCompatEditText phoneNumEdt;
    private AppCompatImageView takePhotoImg;
    private AppCompatImageView photoImgView;
    private AppCompatButton addContactBtn;

    private File file;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        initViewLayout();
        isGrantExternalRW(this);

        takePhotoImg.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                try {
                    file = createPhotoFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (file != null) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    if (isGrantCamera(this) && isGrantExternalRW(this)) {
                        startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);
                    }
                }
            }
        });
        addContactBtn.setOnClickListener(view -> onAddBtnClick());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == TAKE_PHOTO_REQUEST_CODE) {
            Bundle extras = data.getExtras();
            Bitmap pictureBitmap = (Bitmap) extras.get("data");
            photoImgView.setImageBitmap(pictureBitmap);
        }
    }

    private void onAddBtnClick() {
        String name = nameEdt.getText().toString();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast("输入名字");
            return;
        }

        String phoneNum = phoneNumEdt.getText().toString();
        if (TextUtils.isEmpty(phoneNum)) {
            ToastUtil.showToast("输入电话号码");
            return;
        }

        if (file == null) {
            ToastUtil.showToast("请添加照片");
            return;
        }

        DialEntity dialEntity = new DialEntity();
        dialEntity.setContact(name);
        dialEntity.setPhoneNum(phoneNum);
        dialEntity.setPhotoPath(file.getPath());
        dialEntity.save();

        finish();
    }

    private File createPhotoFile() throws IOException {
        String photoName = SimpleDateFormat.getDateInstance().format(new Date());
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(photoName, PHOTO_SUFFIX, storageDir);
    }

    private boolean isGrantExternalRW(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
        return true;
    }

    private boolean isGrantCamera(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, 2);
            return false;
        }

        return true;
    }

    private void initViewLayout() {
        nameEdt = findViewById(R.id.name_edt);
        phoneNumEdt = findViewById(R.id.phone_num_edt);
        takePhotoImg = findViewById(R.id.take_photo_img);
        photoImgView = findViewById(R.id.photo_img_view);
        addContactBtn = findViewById(R.id.ok_btn);
    }
}
