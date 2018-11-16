package com.example.trainschedule.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 * </pre>
 */

public class ViewPagerUtils extends ViewPager{
    //是否可以进行滑动
    private boolean isSlide=false;

    public void setSlide(boolean isSlide){
        isSlide=isSlide;
    }

    public ViewPagerUtils(Context context){
        super(context);
    }

    public ViewPagerUtils(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        return isSlide;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return isSlide;
    }

}
