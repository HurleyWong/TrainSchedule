package com.example.trainschedule.http;

import com.android.volley.Request;

import java.io.IOException;

public abstract class ResultCallback {

    //请求失败
    public abstract void onError(Request request, Exception e);

    //请求成功
    public abstract void onSuccess(String str) throws IOException;
}
