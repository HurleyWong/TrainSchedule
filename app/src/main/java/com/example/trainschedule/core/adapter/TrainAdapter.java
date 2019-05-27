package com.example.trainschedule.core.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainschedule.bean.Station;
import com.example.trainschedule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 * </pre>
 */

public class TrainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Station.ResultBean.ListBean> listBeans = new ArrayList<>();

    /**
     * 声明接口变量
     */
    private OnItemClickListener itemClickListener = null;

    public TrainAdapter(Context context, List<Station.ResultBean.ListBean> listBeans) {
        inflater = LayoutInflater.from(context);
        this.listBeans = listBeans;
    }

    public int getLayoutId() {
        return R.layout.train_recycle_item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainAdapter.ViewHolder(inflater.inflate(R.layout.train_recycle_item, parent, false));
    }

    /**
     * 将数据与界面进行绑定操作
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TrainAdapter.ViewHolder itemHolder = (TrainAdapter.ViewHolder) holder;
        itemHolder.bindHolder(listBeans.get(position));

        //点击事件注册及分发
        if (null != itemClickListener) {
            //监听整个item
            ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    /**
     * 获取数据的数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    /**
     * 定义点击事件接口
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 设置点击事件
     *
     * @param itemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDepartureTime;
        private TextView mTvDepartureStation;
        private TextView mTvCostTime;
        private TextView mTvTrainNo;
        private TextView mTvArrivalTime;
        private TextView mTvArrivalStation;
        private TextView mTvPrice;
        private TextView mTvSeatType;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvDepartureTime = itemView.findViewById(R.id.tv_departure_time);
            mTvDepartureStation = itemView.findViewById(R.id.tv_departure_station);
            mTvCostTime = itemView.findViewById(R.id.tv_cost_time);
            mTvTrainNo = itemView.findViewById(R.id.tv_train_no);
            mTvArrivalTime = itemView.findViewById(R.id.tv_arrival_time);
            mTvArrivalStation = itemView.findViewById(R.id.tv_arrival_station);
            mTvPrice = itemView.findViewById(R.id.tv_price);
            mTvSeatType = itemView.findViewById(R.id.tv_seat_type);
        }

        public void bindHolder(Station.ResultBean.ListBean listBean) {
            mTvDepartureTime.setText(listBean.getDeparturetime());
            mTvDepartureStation.setText(listBean.getStation());
            mTvCostTime.setText(listBean.getCosttime());
            mTvTrainNo.setText(listBean.getTrainno());
            mTvArrivalTime.setText(listBean.getArrivaltime());
            mTvArrivalStation.setText(listBean.getEndstation());
            mTvPrice.setText(listBean.getPriceed());
            mTvSeatType.setText(listBean.getType());
        }
    }
}
