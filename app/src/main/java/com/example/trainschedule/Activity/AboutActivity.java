package com.example.trainschedule.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.trainschedule.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class AboutActivity extends AppCompatActivity{
    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    //应用功能介绍
    @BindView(R.id.app_function)
    public TextView app_function;
    @BindView(R.id.point1)
    public TextView point1;
    @BindView(R.id.point2)
    public TextView point2;
    @BindView(R.id.function1)
    public TextView function1;
    @BindView(R.id.function2)
    public TextView function2;

    //整个Activity视图的根视图
    View decorView;
    //手指按下时的坐标
    float downX,downY;
    //获得手机屏幕的宽度、高度和单位像素
    float screenWidth,screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);
        //initViews();
        ButterKnife.bind(this);

        //Toolbar转化为ActionBar
        setToolbar();

        //设置应用功能文本TextView
        setTextView();

        //获得decorView
        //decorView=getWindow().getDecorView();

        //获得手机屏幕的宽度、高度和单位像素
        /*DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth=metrics.widthPixels;
        screenHeight=metrics.heightPixels;*/
    }

    //初始化控件
    private void initViews(){
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        app_function=findViewById(R.id.app_function);
        point1=findViewById(R.id.point1);
        point2=findViewById(R.id.point2);
        function1=findViewById(R.id.function1);
        function2=findViewById(R.id.function2);
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

    //设置应用功能文本TextView
    private void setTextView(){
        app_function.setText("火车时刻表是一款可以根据车站和车次来查询火车运行时刻表的应用,主要功能如下：");
        point1.setText("·  ");
        point2.setText("·  ");
        function1.setText("输入出发车站和到达车站，显示经过两个车站之间的所有车次");
        function2.setText("输入准确的车次，显示该车次经过的所有车站和具体时刻表以及停留时间");
    }

    //对触摸事件进行处理
    @Override
    public boolean onTouchEvent(MotionEvent event){
        //当手指按下时
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            //获得按下时的X坐标
            downX=event.getX();
        }
        //当手指滑动时
        else if(event.getAction()==MotionEvent.ACTION_MOVE){
            float moveDistanceX=event.getX()-downX;
            //如果是向右滑动
            if(moveDistanceX>0){
                //设置界面的X到滑动的位置
                decorView.setX(moveDistanceX);
            }
        }
        //当抬起手指时
        else if(event.getAction()==MotionEvent.ACTION_UP){
            //获得滑动的距离
            float moveDistanceX=event.getX()-downX;
            if(moveDistanceX>screenWidth/2){
                //如果滑动的距离超过了手机屏幕的一半，滑动屏幕后再结束当前Activity
                //continueMove(moveDistanceX);
                finish();
            }
            else{
                //如果滑动的距离没有超过手机屏幕的一半，往回滑动
                //rebackToLeft(moveDistanceX);
                decorView.setX(0);
            }
        }
        return super.onTouchEvent(event);
    }

    //从当前位置一直往右滑动到消失
    private void continueMove(float moveDistanceX){
        //从当前位置移动到右侧
        ValueAnimator animator=ValueAnimator.ofFloat(moveDistanceX,screenWidth);
        //1秒的时间结束
        animator.setDuration(1000);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                //位移
                float x=(float)(animation.getAnimatedValue());
                decorView.setX(x);
            }
        });

        //动画结束时结束当前Activity
        animator.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation){
                super.onAnimationEnd(animation);
                finish();
            }
        });
    }

    //滑动到一半时，滑回去
    private void rebackToLeft(float moveDistanceX){
        ObjectAnimator.ofFloat(decorView,"X",moveDistanceX,0).setDuration(300).start();
    }
}

















