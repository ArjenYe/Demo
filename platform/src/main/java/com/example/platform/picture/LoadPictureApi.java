package com.example.platform.picture;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author arjen
 */

public interface LoadPictureApi {
    @GET("/ting/pic/item/96dda144ad345982c1d5272a08f431adcbef842f.jpg")
    Observable<ResponseBody> loadPicture();
}
