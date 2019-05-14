package com.example.trainschedule.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //初始化Fresco框架
        Fresco.initialize(this);

        //初始化工具类
        Utils.init(this);
    }

    public static App getInstance() {
        return instance;
    }


    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

}
