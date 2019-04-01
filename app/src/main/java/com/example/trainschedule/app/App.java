package com.example.trainschedule.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco框架
        Fresco.initialize(this);
    }
}
