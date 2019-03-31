package com.example.trainschedule.module.activity;

import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.trainschedule.R;
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

public class SupportActivity extends AppCompatActivity{
    private static final String TAG = "SupportActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.not_found_image)
    public ImageView mIvNotFound;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //initViews();
        ButterKnife.bind(this);

        //Toolbar转化为ActionBar
        ActionBarUtils.setToolBar(this, toolbar, R.drawable.ic_menu, false);

        //警告Dialog
        DialogUtils.showAlertDialog(this, null, getString(R.string.wrong_404), getString(R.string.positive));
    }

    public int getLayoutId() {
        return R.layout.fragment_support;
    }

    //对Toolbar的菜单选项进行监听回调
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                //点击返货箭头返回上一页面
                //返回操作方法
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
