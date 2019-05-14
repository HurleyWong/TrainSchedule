package com.example.trainschedule.http;

import java.io.IOException;

import okhttp3.Request;

public abstract class ResultCallback {

    /**
     * 请求失败
     *
     * @param request
     * @param e
     */
    public abstract void onError(Request request, Exception e);

    /**
     * 请求成功
     *
     * @param str
     * @throws IOException
     */
    public abstract void onSuccess(String str) throws IOException;
}
