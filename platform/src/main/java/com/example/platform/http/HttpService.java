package com.example.platform.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author arjen
 */

public final class HttpService {
    private static String baseUrl = "https://api.douban.com/v2/";
    private static OkHttpClient okHttpClient;

    public static void init() {
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new StethoInterceptor()).build();
    }

    public static <T> T createService(final Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        return retrofit.create(clazz);
    }

    public static <T> T createService(final Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();

        return retrofit.create(clazz);
    }
}
