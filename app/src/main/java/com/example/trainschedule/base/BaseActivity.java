package com.example.trainschedule.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.blankj.utilcode.util.ToastUtils;
import com.example.trainschedule.R;
import com.gyf.barlibrary.ImmersionBar;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/31 9:02 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    protected Toolbar toolbar;

    private Unbinder unbinder;

    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
        initToolbar();
        initView();
        ImmersionBar.with(this)
                //与导航栏同色
                .statusBarColor(R.color.colorPrimary)
                //解决状态栏和布局重叠问题
                .fitsSystemWindows(true)
                //初始化
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ImmersionBar.with(this).destroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar == null) {
            throw new NullPointerException("toolbar can not be null");
        }
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(showHomeAsUp());
        //toolbar除掉阴影
        getSupportActionBar().setElevation(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(0);
        }
    }

    /**
     * 是否显示返回键
     *
     * @return
     */
    protected boolean showHomeAsUp() {
        return false;
    }

    /**
     * 显示Toast
     *
     * @param text
     */
    protected void toast(CharSequence text) {
        //设置Toast背景颜色
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.gray));
        ToastUtils.showShort(text);
    }

    /**
     * 显示Toast
     *
     * @param id
     */
    protected void toast(int id) {
        //设置Toast背景颜色
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.gray));
        ToastUtils.showShort(id);
    }

}
