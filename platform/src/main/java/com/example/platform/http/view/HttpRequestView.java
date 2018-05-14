package com.example.platform.http.view;

import com.example.platform.http.model.BookEntry;

/**
 * @author arjen
 */

public interface HttpRequestView {
    void showProgress(boolean show);

    void refreshBook(BookEntry bookEntry);
}
