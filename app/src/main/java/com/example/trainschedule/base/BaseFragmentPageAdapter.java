package com.example.trainschedule.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午6:59
 *      desc   : FragmentPagerAdapter基类
 * </pre>
 */
public abstract class BaseFragmentPageAdapter<T extends Fragment> extends FragmentPagerAdapter {

    //Fragment集合
    private List<T> mFragments = new ArrayList<>();

    //当前正在显示的Fragment
    private T mCurrentFragment;

    public BaseFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        init(fm, mFragments);
    }

    //在Activity中使用ViewPager适配器
    public BaseFragmentPageAdapter(FragmentActivity activity) {
        this(activity.getSupportFragmentManager());
    }

    //在Fragment中使用ViewPager适配器
    public BaseFragmentPageAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager());
    }

    //初始化Fragment
    protected abstract void init(FragmentManager fm, List<T> list);

    @Override
    public T getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    //设置主要item
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            //记录当前的Fragment对象
            mCurrentFragment = (T) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    //获取Fragment集合
    public List<T> getAllFragment() {
        return mFragments;
    }

    //获取当前Fragment
    public T getCurrentFragment() {
        return mCurrentFragment;
    }
}















