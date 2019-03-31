package com.example.trainschedule.module.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.utils.ActionBarUtils;
import com.example.trainschedule.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/20
 * </pre>
 */

public class SupportActivity extends BaseActivity {
    private static final String TAG = "SupportActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.not_found_image)
    public ImageView mIvNotFound;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_support;
    }

    @Override
    protected void initView() {
        //警告Dialog
        DialogUtils.showAlertDialog(this, null, getString(R.string.wrong_404), getString(R.string.positive));
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
