package com.example.trainschedule.module.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.utils.ActionBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 * </pre>
 */

public class AboutActivity extends BaseActivity {
    private static final String TAG = "AboutActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.app_function)
    public TextView mAppFunc;
    @BindView(R.id.point1)
    public TextView mTvPoint1;
    @BindView(R.id.point2)
    public TextView mTvPoint2;
    @BindView(R.id.function1)
    public TextView mTvFunc1;
    @BindView(R.id.function2)
    public TextView mTvFunc2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView() {
        mAppFunc.setText(R.string.app_func);
        mTvPoint1.setText(R.string.func_paragraph);
        mTvPoint2.setText(R.string.func_paragraph);
        mTvFunc1.setText(R.string.app_func1);
        mTvFunc2.setText(R.string.app_func2);
    }

    /**
     * 显示返回键
     *
     * @return
     */
    @Override
    protected boolean showHomeAsUp() {
        return true;
    }
}

















