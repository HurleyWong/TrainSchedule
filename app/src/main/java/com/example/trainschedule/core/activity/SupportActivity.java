package com.example.trainschedule.core.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.utils.DialogUtils;

import butterknife.BindView;

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
    @BindView(R.id.iv_not_found)
    public ImageView mIvNotFound;

    @Override
    protected int getLayoutId() {
        return R.layout.support_fragment;
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
