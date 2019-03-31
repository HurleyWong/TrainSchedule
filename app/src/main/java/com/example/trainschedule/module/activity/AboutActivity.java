package com.example.trainschedule.module.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.trainschedule.R;
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

public class AboutActivity extends AppCompatActivity{
    private static final String TAG = "AboutActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    //应用功能介绍
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

    //整个Activity视图的根视图
    View decorView;
    //手指按下时的坐标
    float downX,downY;
    //获得手机屏幕的宽度、高度和单位像素
    float screenWidth,screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //initViews();
        ButterKnife.bind(this);

        //Toolbar转化为ActionBar
        ActionBarUtils.setToolBar(this, toolbar, R.drawable.ic_menu, false);

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

    public int getLayoutId() {
        return R.layout.fragment_about;
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
        mAppFunc.setText(R.string.app_func);
        mTvPoint1.setText(R.string.func_paragraph);
        mTvPoint2.setText(R.string.func_paragraph);
        mTvFunc1.setText(R.string.app_func1);
        mTvFunc2.setText(R.string.app_func2);
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

















