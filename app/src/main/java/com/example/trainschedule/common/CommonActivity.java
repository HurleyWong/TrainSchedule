package com.example.trainschedule.common;

import android.content.pm.ActivityInfo;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午5:44
 *      desc   : 该项目的Activity基类
 * </pre>
 */
public abstract class CommonActivity extends UIActivity implements OnTitleBarListener {

    //View注解
    private Unbinder mButterKnife;

    @Override
    public void init() {
        //初始化标题栏的监听
        if (getTitleBarId() > 0) {
            if (findViewById(getTitleBarId()) instanceof TitleBar) {
                ((TitleBar) findViewById(getTitleBarId())).setOnTitleBarListener(this);
            }
        }

        mButterKnife = ButterKnife.bind(this);

        initOrientation();

        super.init();
    }

    //初始化横竖屏方向，会和LauncherTheme主题样式产生冲突，注意不要同时使用
    protected void initOrientation() {
        //如果没有指定屏幕方向，则默认为竖屏
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    //设置标题栏的标题
    @Override
    public void setTitle(int titleId) {
        setTitle(getText(titleId));
    }

    //设置标题栏的标题
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        TitleBar titleBar = getTitleBar();
        if (title != null) {
            titleBar.setTitle(title);
        }
    }

    //获得标题栏
    protected TitleBar getTitleBar() {
        if (getTitleBarId() > 0 && findViewById(getTitleBarId()) instanceof TitleBar) {
            return findViewById(getTitleBarId());
        }
        return null;
    }

    //获取状态栏字体颜色
    @Override
    public boolean statusBarDarkFont() {
        //黑色字体
        return true;
    }

    //标题栏左边View被点击
    @Override
    public void onLeftClick(View v) {
        //返回
        onBackPressed();
    }

    //标题栏中间View被点击
    @Override
    public void onTitleClick(View v) {}

    //标题栏右边View被点击
    @Override
    public void onRightClick(View v) {}

    @Override
    protected void onResume() {
        super.onResume();
        //TODO 手动统计页面
        //TODO 友盟统计
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO 手动统计页面
        //TODO 友盟统计
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mButterKnife != null) {
            //解绑
            mButterKnife.unbind();
        }
    }
}
