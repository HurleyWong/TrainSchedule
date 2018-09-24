package com.example.trainschedule;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class ApplicationContext extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
