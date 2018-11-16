package com.example.trainschedule.common;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.example.trainschedule.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午1:21
 *      desc   : 支持沉浸式和侧滑的Activity基类（默认开启沉浸式状态栏和侧滑功能）
 * </pre>
 */
public abstract class UIActivity extends BaseActivity
        implements BGASwipeBackHelper.Delegate, ViewTreeObserver.OnGlobalLayoutListener {

    //状态栏沉浸
    private ImmersionBar mImmersionBar;
    //侧滑返回
    private BGASwipeBackHelper mSwipeBackHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //在super.onCreate(savedInstanceState)方法之前调用沉浸式状态栏方法
        initSwipeBackHelper();
        super.onCreate(savedInstanceState);
    }

    public void init() {
        //初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();
        }

        //设置标题栏
        if (getTitleBarId() > 0) {
            ImmersionBar.setTitleBar(this, findViewById(getTitleBarId()));
        }
        super.init();
    }

    public BGASwipeBackHelper getSwipeBackHelper() {
        return mSwipeBackHelper;
    }

    //初始化滑动返回，在super.onCreate(savedInstanceState)之前调用该方法
    private void initSwipeBackHelper() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        //必须在Application的onCreate方法中执行该方法，用BGASwipeBackHelper.init来初始化滑动返回

        //设置滑动返回是否可用，默认为true
        mSwipeBackHelper.setSwipeBackEnable(true);
        //设置是否仅跟踪左侧边缘的滑动返回，默认为true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        //设置是否是微信滑动返回样式，默认为true
        mSwipeBackHelper.setIsWeChatStyle(true);
        //设置触发释放后自动滑动返回的阈值，默认值为0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
    }

    //是否支持滑动返回
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     * @param slideOffset       从0到1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {}

    //没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
    @Override
    public void onSwipeBackLayoutCancel() {}

    //滑动返回执行完毕，销毁当前Activity
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    @Override
    public void onBackPressed() {
        //正在滑动返回的时候取消返回
        if (mSwipeBackHelper.isSliding()) {
            return ;
        }
        //回到上一个Activity，并销毁当前Activity
        mSwipeBackHelper.backward();
        super.onBackPressed();
    }

    //是否使用沉浸式状态栏
    public boolean isStatusBarEnabled() {
        return true;
    }

    //获取状态栏沉浸的配置对象
    public ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    //初始化沉浸式状态栏
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                //默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                //解决软键盘与底部输入框冲突问题，默认为false，重载方法可以指定软键盘mode
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        return mImmersionBar;
    }

    @Override
    public void onGlobalLayout() {}

    //获取状态栏字体颜色
    public boolean statusBarDarkFont() {
        //返回false表示白色字体
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            //必须调用该方法，防止内存泄漏
            mImmersionBar.destroy();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}





















