package com.example.trainschedule.common;

import android.app.Application;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午6:53
 *      desc   : 支持侧滑的UIApplication基类
 * </pre>
 */
public abstract class UIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 必须在Application的onCreate方法中执行BGASwipeBackHelper.init来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，则把该界面里比较特殊的View的class添加到该集合中，例如WebView和SurfaceView
         */
        BGASwipeBackHelper.init(this, null);
    }
}
