package com.example.platform.http.presenter;

/**
 * @author arjen
 */

public interface HttpRequestPresenter {

    void getBook(String name, String tag, int start, int count);
}
