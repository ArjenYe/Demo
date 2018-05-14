package com.example.platform.http.api;

import com.example.platform.http.model.BookEntry;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author arjen
 */

public interface BookApi {
    @GET("book/search")
    Observable<Response<BookEntry>> getBook(@Query("q") String name,
                                            @Query("tag") String tag,
                                            @Query("start") int start,
                                            @Query("count") int count);
}
