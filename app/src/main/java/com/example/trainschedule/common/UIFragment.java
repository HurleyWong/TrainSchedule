package com.example.trainschedule.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.trainschedule.base.BaseFragment;
import com.gyf.barlibrary.ImmersionBar;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午6:41
 *      desc   : 支持沉浸式Fragment懒加载基类（默认不开启沉浸式）
 * </pre>
 */
public abstract class UIFragment extends BaseFragment {
    //状态栏沉浸
    private ImmersionBar mImmersionBar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化沉浸式状态栏
        if (isVisibleToUser() && isStatusBarEnabled() && isLazyLoad()) {
            statusBarConfig().init();
        }

        //设置标题栏
        if (getTitleBarId() > 0) {
            ImmersionBar.setTitleBar(mActivity, findViewById(getTitleBarId()));
        }
    }

    //是否在Fragment中使用沉浸式
    @Override
    public boolean isStatusBarEnabled() {
        return false;
    }

    //获取状态栏沉浸的配置对象
    protected ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    //初始化沉浸式状态栏
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                //默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                //解决软键盘与底部输入框冲突问题，默认为false，重载方法可以指定软键盘mode
                .keyboardEnable(true);
        return mImmersionBar;
    }

    //获取状态栏字体颜色
    protected boolean statusBarDarkFont() {
        //黑色字体
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isStatusBarEnabled() && isLazyLoad()) {
            //重新初始化状态栏
            statusBarConfig().init();
        }
    }
}










