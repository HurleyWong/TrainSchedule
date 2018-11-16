package com.example.trainschedule.base;

import android.app.Activity;
import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午7:16
 *      desc   : Activity中优化Handler基类
 * </pre>
 */
public abstract class BaseActivityHandler<T extends Activity> extends Handler {

    private final WeakReference<T> mActivity;

    public BaseActivityHandler(T activity) {
        mActivity = new WeakReference<>(activity);
    }

    //判断当前Handler是否可用
    public boolean isEnabled() {
        return getActivity() != null && !getActivity().isFinishing();
    }

    //获取Activity对象
    public T getActivity() {
        return mActivity.get();
    }

    //在Activity销毁前移除所有的任务
    public void onDestroy() {
        //删除所有的回调函数和消息
        removeCallbacksAndMessages(null);
    }
}
