package com.example.trainschedule.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainschedule.listener.OnItemClickListener;
import com.example.trainschedule.listener.OnItemLongClickListener;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午7:38
 *      desc   :
 * </pre>
 */
public abstract class BaseRecyclerViewAdapter<T, VH extends BaseRecyclerViewAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {


    //设置RecyclerView条目点击监听
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    //设置RecyclerView条目长按监听
    private OnItemLongClickListener mOnItemLongClickListener;
    public void setOnItemlongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }

    /**
     * ViewHoler，由子类ViewHolder继承
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ViewHolder(ViewGroup parent, int layoutId) {
            this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        }

        public ViewHolder(View itemView) {
            super(itemView);
            //设置item的监听事件
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (mOnItemLongClickListener != null) {
                return mOnItemLongClickListener.onItemLongClick(view, getLayoutPosition());
            }
            return false;
        }


    }

}
