package com.example.trainschedule.base;

import android.support.v7.widget.RecyclerView;

import com.example.trainschedule.listener.OnScrollingListener;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/18 下午2:36
 *      desc   : 自定义滚动监听器
 * </pre>
 */
public class BaseScrollListener extends RecyclerView.OnScrollListener {

    //RecyclerView对象
    private RecyclerView mRecyclerView;

    //设置RecyclerView条目滚动监听
    private OnScrollingListener onScrollingListener;

    //自定义滚动监听器
    private BaseScrollListener mScrollListener;

    public void setOnScrollingListener(OnScrollingListener l) {
        onScrollingListener = l;

        //如果当前已经有设置滚动监听，再次设置需要移除原有的监听器
        if (mScrollListener == null) {
            mScrollListener = new BaseScrollListener();
        }else {
            mRecyclerView.removeOnScrollListener(mScrollListener);
        }
        //用户设置了滚动监听，需要给RecyclerView设置监听
        if (mRecyclerView != null) {
            //添加滚动监听
            mRecyclerView.addOnScrollListener(mScrollListener);
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

        if (onScrollingListener == null) return;

        if (newState == RecyclerView.SCROLL_STATE_IDLE) {

            if (!recyclerView.canScrollVertically(1)) {
                //是否能向下滚动，false表示已经滚动到底部
                onScrollingListener.onScrollDown(recyclerView);
            }else if (!recyclerView.canScrollVertically(-1)) {
                //是否能向上滚动，false表示已经滚动到顶部
                onScrollingListener.onScrollTop(recyclerView);
            }

        }else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
            //正在滚动中
            onScrollingListener.onScrolling(recyclerView);
        }
    }
}
