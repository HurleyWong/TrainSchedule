package com.example.trainschedule.listener;

import android.view.View;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午7:45
 *      desc   : RecyclerView 条目点击监听类
 * </pre>
 */
public interface OnItemClickListener {

    /**
     * 当 RecyclerView 某个 item 被点击时回调
     *
     * @param itemView 被点击的 item 对象
     * @param position 被点击的 item 位置
     */
    void onItemClick(View itemView, int position);
}
