package com.example.trainschedule.http;

import com.example.trainschedule.api.UrlContainer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/3 1:04 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class RetrofitManager {

    public static <T> T create(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlContainer.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
