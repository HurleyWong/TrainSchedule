package com.example.trainschedule.utils;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ActionBarUtils {

    private static final String TAG = "ActionBarUtils";

    /**
     * 将ToolBar转化为ActionBar
     * @param activity
     * @param toolbar
     * @param resId             //更改的返回图标
     * @param isChangeIcon      //是否更改返回图标
     */
    public static void setToolBar(AppCompatActivity activity, Toolbar toolbar,
                                  int resId, boolean isChangeIcon) {
        //将Toolbar转化为ActionBar
        activity.setSupportActionBar(toolbar);
        //获取ActionBar
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            //隐藏ActionBar
            //actionBar.hide();
            if (isChangeIcon) {
                actionBar.setHomeAsUpIndicator(resId);
            }
            //设置左上角的按钮图标可以点击
            actionBar.setDisplayHomeAsUpEnabled(true);
            //是否显示标题
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }
}
