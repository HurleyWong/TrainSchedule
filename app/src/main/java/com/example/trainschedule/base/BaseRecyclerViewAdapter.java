package com.example.trainschedule.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      github : https://github.com/HurleyJames
 *      time   : 2018/11/16 下午7:38
 *      desc   : RecyclerView适配器基类
 * </pre>
 */
public abstract class BaseRecyclerViewAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    /**
     * 列表数据
     */
    private List<T> mDataSet;
    /**
     * 当前列表的页码，默认为第一页，用于分页加载功能
     */
    private int mPageNumber = 1;
    /**
     * 是否是最后一页，默认为false，用于分页加载功能
     */
    private boolean mLastPage;

    /**
     * RecyclerView对象
     */
    private RecyclerView mRecyclerView;
    /**
     * 上下文对象，注意不要在构造函数中使用
     */
    private Context mContext;

    /**
     * 标记对象
     */
    private Object mTag;

    /**
     * 自定义滚动监听器
     */
    private BaseScrollListener mScrollListener;

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 设置新的数据
     * @param data
     */
    private void setData(List<T> data) {
        mDataSet = data;
        notifyDataSetChanged();
    }

    /**
     * 获取当前数据
     * @return
     */
    public List<T> getData() {
        return mDataSet;
    }

    /**
     * 追加数据
     * @param data
     */
    public void addData(List<T> data) {
        //追加的数据不能为空
        if (data == null || data.size() == 0) return;

        if (mDataSet == null || mDataSet.size() == 0) {
            setData(data);
        } else {
            mDataSet.addAll(data);
            notifyItemRangeInserted(mDataSet.size() - data.size(), data.size());
        }
    }

    /**
     * 清空当前数据
     */
    public void clearData() {
        //当前的数据不能为空
        if (mDataSet == null || mDataSet.size() == 0) return;

        mDataSet.clear();
        notifyDataSetChanged();
    }

    /**
     * 获取某个位置上的数据
     * @param position
     * @return
     */
    public T getItem(int position) {
        return mDataSet.get(position);
    }

    /**
     * 更新某个位置上的数据
     * @param position
     * @param item
     */
    public void setItem(int position, T item) {
        if (mDataSet == null) mDataSet = new ArrayList<>();
        mDataSet.set(position, item);
        notifyItemChanged(position);
    }

    /**
     * 添加单条数据
     * @param item
     */
    public void addItem(T item) {
        addItem(mDataSet.size() - 1, item);
    }

    /**
     * 添加单条数据
     * @param position
     * @param item
     */
    public void addItem(int position, T item) {
        if (mDataSet == null) {
            mDataSet = new ArrayList<>();
        }

        //如果是在for循环添加后要记得position++
        if (position < mDataSet.size()) {
            mDataSet.add(position, item);
        } else {
            mDataSet.add(item);
            position = mDataSet.size() - 1;
        }
        //通知适配器添加数据的位置，产生动画效果
        notifyItemInserted(position);
    }

    /**
     * 删除单条数据
     * @param item
     */
    public void removeItem(T item) {
        int index = mDataSet.indexOf(item);
        if (index != -1) {
            removeItem(index);
        }
    }

    /**
     * 删除单条数据
     * @param position
     */
    public void removeItem(int position) {
        //如果是在for循环删除后要记得i--
        mDataSet.remove(position);
        //通知适配器删除数据的位置，产生动画效果
        notifyItemRemoved(position);
    }

    /**
     * 获取RecyclerView对象，需要在setAdapter之后绑定
     * @return
     */
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    /**
     * 获取上下文对象，注意不要在构造方法中调用
     * @return
     */
    public Context getContext() {
        return mContext;
    }

    /**
     * 获取当前的页码
     * @return
     */
    public int getPageNumber() {
        return mPageNumber;
    }

    /**
     * 设置当前的页码
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        mPageNumber = pageNumber;
    }

    /**
     * 当前是否为最后一页
     * @return
     */
    public boolean isLastPage() {
        return mLastPage;
    }

    /**
     * 设置是否为最后一页
     * @param lastPage
     */
    public void setLastPage(boolean lastPage) {
        mLastPage = lastPage;
    }

    /**
     * 获取标记
     * @return
     */
    public Object getTag() {
        return mTag;
    }

    /**
     * 设置标记
     * @param tag
     */
    public void setTag(Object tag) {
        mTag = tag;
    }


}
















