package com.example.trainschedule.base;

import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trainschedule.listener.OnItemClickListener;
import com.example.trainschedule.listener.OnItemLongClickListener;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/17 下午11:19
 *      desc   : ViewHoler基类，由子类ViewHolder继承
 * </pre>
 */
public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    /**
     * 设置RecyclerView条目点击监听
     */
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    /**
     * 设置RecyclerView条目长按监听
     */
    private OnItemLongClickListener mOnItemLongClickListener;
    public void setOnItemlongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }

    public BaseViewHolder(ViewGroup parent, int layoutId) {
        this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    public BaseViewHolder(View itemView) {
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

    public final <T extends View> T findView(@IdRes int id) {
        return (T) itemView.findViewById(id);
    }

    public final BaseViewHolder setText(@IdRes int id, String text) {
        if (text == null) {
            text= "";
        }
        View view = findView(id);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        }
        return this;
    }

    public final BaseViewHolder setVisibility(@IdRes int id, int visibility) {
        View view = findView(id);
        if (view != null) {
            view.setVisibility(visibility);
        }
        return this;
    }

    public final BaseViewHolder setColor(@IdRes int id, @ColorInt int color) {
        View view = findView(id);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(color);
        }
        return this;
    }

    public final BaseViewHolder setImage(@IdRes int id, int resId) {
        View view = findView(id);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(resId);
        }
        return this;
    }

}
