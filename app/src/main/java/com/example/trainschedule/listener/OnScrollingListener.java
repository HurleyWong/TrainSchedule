package com.example.trainschedule.listener;

import android.support.v7.widget.RecyclerView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/18 下午2:39
 *      desc   : RecyclerView滚动监听类
 * </pre>
 */
public interface OnScrollingListener {

    //列表滚动到最顶部
    void onScrollTop(RecyclerView recyclerView);

    //列表滚动到最底部
    void onScrollDown(RecyclerView recyclerView);

    //列表滚动中
    void onScrolling(RecyclerView recyclerView);
}
