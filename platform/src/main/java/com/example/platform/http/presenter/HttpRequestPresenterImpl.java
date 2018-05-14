package com.example.platform.http.presenter;

import com.example.platform.http.HttpService;
import com.example.platform.http.api.BookApi;
import com.example.platform.http.model.BookEntry;
import com.example.platform.http.view.HttpRequestView;

import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arjen
 */

public class HttpRequestPresenterImpl implements HttpRequestPresenter {
    private BookApi bookApi;
    private HttpRequestView httpRequestView;

    public HttpRequestPresenterImpl(HttpRequestView httpRequestView) {
        this.httpRequestView = httpRequestView;
        bookApi = HttpService.createService(BookApi.class);
    }

    @Override
    public void getBook(String name, String tag, int start, int count) {
        httpRequestView.showProgress(true);
        bookApi.getBook(name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<BookEntry>>() {
                    @Override
                    public void onNext(Response<BookEntry> response) {
                        httpRequestView.refreshBook(response.body());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onCompleted() {
                        httpRequestView.showProgress(false);
                    }
                });
    }
}
