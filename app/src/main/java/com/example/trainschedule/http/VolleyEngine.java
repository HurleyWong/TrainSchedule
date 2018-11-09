package com.example.trainschedule.http;

import android.os.Handler;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trainschedule.ApplicationContext;

import java.io.IOException;

public class VolleyEngine {

    private static final String TAG = "VolleyEngine";

    private static volatile VolleyEngine mInstance;

    private Handler mHandler;

    public static VolleyEngine getInstance() {
        if (mInstance == null) {
            synchronized (VolleyEngine.class) {
                if (mInstance == null) {
                    mInstance = new VolleyEngine();
                }
            }
        }
        return mInstance;
    }

    private void getData(String url, ApplicationContext context, final ResultCallback callback) {
        //创建请求对象
        //使用Volley框架
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            try {
                                callback.onSuccess(response);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            error.printStackTrace();
                        }
                    }
                });
            }
        });
        //把请求对象加入请求队列中
        new Volley().newRequestQueue(context).add(request);
    }
}
