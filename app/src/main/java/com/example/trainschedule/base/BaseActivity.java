package com.example.trainschedule.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.trainschedule.utils.KeyboardUtils;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午1:12
 *      desc   : Activity基类
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void init() {
        initView();
        initData();
    }

    //引入布局
    protected abstract int getLayoutId();

    //标题栏id
    protected abstract int getTitleBarId();

    //初始化控件
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    @Override
    public void finish() {
        //隐藏软键盘，避免软键盘引发的内存泄漏
        KeyboardUtils.hideKeyboard(getCurrentFocus());
        super.finish();
    }

    /**
     * 跳转到其他Activity
     * @param clazz         目标Activity的class
     */
    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    /**
     * 延迟执行某个任务
     * @param action        Runnable对象
     * @return
     */
    public boolean post(Runnable action) {
        return getWindow().getDecorView().post(action);
    }

    /**
     * 延迟某个时间执行某个任务
     * @param action        Runnable对象
     * @param delayMills    延迟的时间
     * @return
     */
    public boolean postDelayed(Runnable action, long delayMills) {
        return getWindow().getDecorView().postDelayed(action, delayMills);
    }

    /**
     * 删除某个延迟任务
     * @param action        Runnable对象
     * @return
     */
    public boolean removeCallbacks(Runnable action) {
        if (getWindow().getDecorView() != null) {
            return getWindow().getDecorView().removeCallbacks(action);
        } else {
            return true;
        }
    }
}















