package com.example.trainschedule.listener;

import android.view.View;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午7:46
 *      desc   : RecyclerView条目长按监听类
 * </pre>
 */
public interface OnItemLongClickListener {

    /**
     * 当RecyclerView某个条目被长按时回调
     *
     * @param itemView 被点击的item对象
     * @param position 被点击的item位置
     * @return 是否拦截事件
     */
    boolean onItemLongClick(View itemView, int position);
}
