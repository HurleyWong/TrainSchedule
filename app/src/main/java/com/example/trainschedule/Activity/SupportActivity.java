package com.example.trainschedule.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.trainschedule.R;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/20
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class SupportActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView not_found_image;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_support);
        initViews();

        //Toolbar转化为ActionBar
        setToolbar();

        showDialog();
    }

    //初始化控件
    private void initViews(){
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        not_found_image=findViewById(R.id.not_found_image);
    }

    //Toolbar转化为ActionBar
    public void setToolbar(){
        //将Toolbar转化为Actionbar
        setSupportActionBar(toolbar);
        //获取ActionBar
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            //隐藏actionBar
            //actionBar.hide();
            //设置左上角的按钮图标可以点击
            actionBar.setDisplayHomeAsUpEnabled(true);
            //是否显示标题
            actionBar.setDisplayShowTitleEnabled(true);
        }
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

    public void showDialog(){
        //创建AlertDialog的构造器对象
        AlertDialog.Builder builder=new AlertDialog.Builder(SupportActivity.this);
        //设置构造器标题
        //builder.setTitle("错误");
        //构造器内容。为对话框设置文本项
        builder.setMessage("抱歉，开发者尚未开发此功能");
        //为构造器设置确定按钮，第一个参数为按钮显示的文本信息，第二个参数为点击后的监听事件
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
            //第一个参数dialog是点击的确定按钮所属的dialog对象，第二个对象which是按钮的标示值
            @Override
            public void onClick(DialogInterface dialog,int which){
                //onBackPressed();
            }
        });
        //利用构造器创建AlertDialog对象，实现实例化
        alertDialog=builder.create();
        if(alertDialog!=null&&!alertDialog.isShowing()){
            alertDialog.show();
        }
    }
}
