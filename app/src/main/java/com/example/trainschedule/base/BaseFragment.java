package com.example.trainschedule.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午6:09
 *      desc   : Fragment懒加载基类
 * </pre>
 */
public abstract class BaseFragment extends Fragment {

    //是否已经懒加载
    private boolean isLazyLoad = false;
    //根布局
    private View mRootView;
    //Activity对象
    public Activity mActivity;
    //是否对用户可见
    private boolean isVisibleToUser;

    //获得全局的，防止使用getActivity()为空
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Activity getSupportActivity() {
        return mActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mRootView == null && getLayoutId() > 0) {
            mRootView = inflater.inflate(getLayoutId(), null);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isVisibleToUser && !isLazyLoad() && getView() != null) {
            isLazyLoad = true;
            init();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser && !isLazyLoad() && getView() != null) {
            isLazyLoad = true;
            init();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    //对用户是否可见
    public boolean isVisibleToUser() {
        return isVisibleToUser;
    }

    @Override
    public View getView() {
        return mRootView;
    }

    protected boolean isLazyLoad() {
        return isLazyLoad;
    }

    //是否在Fragment使用沉浸式
    protected boolean isStatusBarEnabled() {
        return false;
    }

    protected void init() {
        initView();
        initData();
    }

    //引入布局
    protected abstract int getLayoutId();

    //标题栏id
    protected abstract int getTitleBarId();

    //初始化控件
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //根据资源id获取一个View
    protected <T extends View> T findViewById(@IdRes int id) {
        return (T) getView().findViewById(id);
    }

    protected <T extends View> T findActivityViewById(@IdRes int id) {
        return (T) mActivity.findViewById(id);
    }

    //跳转到其它Activity
    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(getContext(), clazz));
    }

    //Fragment返回键被按下时回调
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //默认不拦截按键事件，传递给Activity
        return false;
    }
}





















