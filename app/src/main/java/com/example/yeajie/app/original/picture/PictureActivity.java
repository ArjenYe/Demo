package com.example.yeajie.app.original.picture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;

import com.example.platform.http.HttpService;
import com.example.platform.picture.LoadPictureApi;
import com.example.yeajie.app.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arjen
 */

public class PictureActivity extends Activity {
    private static final int SUCCESS = 0;
    private static final String imgUrl = "http://a.hiphotos.baidu.com/ting/pic/item/96dda144ad345982c1d5272a08f431adcbef842f.jpg";
    private AppCompatImageView imgView1;
    private AppCompatImageView imgView2;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case SUCCESS:
                    imgView1.setImageBitmap((Bitmap) message.obj);
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        imgView1 = (AppCompatImageView) findViewById(R.id.img_view_1);
        imgView2 = (AppCompatImageView) findViewById(R.id.img_view_2);

        //Method 1: OkHttp
        loadPicture();

        //Method 2: Retrofit2 + RxJava
        loadPicture("http://a.hiphotos.baidu.com");
    }

    private void loadPicture(String baseUrl) {
        LoadPictureApi loadPictureApi = HttpService.createService(LoadPictureApi.class, baseUrl);
        loadPictureApi.loadPicture()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ResponseBody response) {
                        Bitmap bitmap = BitmapFactory.decodeStream(response.byteStream());
                        imgView2.setImageBitmap(bitmap);
                    }
                });
    }

    private void loadPicture() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(imgUrl).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                /*Only the original thread that created a view hierarchy can touch its views
                imgView.setImageBitmap(BitmapFactory.decodeStream(response.body().byteStream()));*/

                Message message = handler.obtainMessage();
                message.what = SUCCESS;
                message.obj = BitmapFactory.decodeStream(response.body().byteStream());
                handler.sendMessage(message);
            }
        });
    }
}

/*        //from path
        Bitmap fromPath = BitmapFactory.decodeFile(path);

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //from stream
        Bitmap fromStream = BitmapFactory.decodeStream(fileInputStream);

        //from local res
        Bitmap fromLocalRes = BitmapFactory.decodeResource(getResources(), R.drawable.barcode_img);*/
