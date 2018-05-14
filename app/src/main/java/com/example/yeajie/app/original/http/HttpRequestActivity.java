package com.example.yeajie.app.original.http;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.platform.http.model.BookEntry;
import com.example.platform.http.presenter.HttpRequestPresenter;
import com.example.platform.http.presenter.HttpRequestPresenterImpl;
import com.example.platform.http.view.HttpRequestView;
import com.example.yeajie.app.R;
import com.example.widget.core.CircleProgress;
import com.example.widget.util.ToastUtil;

/**
 * @author arjen
 */

public class HttpRequestActivity extends Activity implements HttpRequestView {
    private HttpRequestPresenter presenter;
    private CircleProgress circleProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        presenter = new HttpRequestPresenterImpl(this);
        circleProgress = CircleProgress.create(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getBook("西游记", "", 0, 1);
    }

    @Override
    public void refreshBook(BookEntry bookEntry) {
        ToastUtil.showToast(this, String.valueOf(bookEntry.count));
    }

    @Override
    public void showProgress(boolean show) {
//        if (show) {
//            circleProgress.show();
//        } else {
//            circleProgress.dismiss();
//        }
    }
}
