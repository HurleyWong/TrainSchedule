package com.example.trainschedule.core.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainschedule.bean.Train;
import com.example.trainschedule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class TrainTimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Train.ResultBean.ListBean> listBeans = new ArrayList<>();
    private List<Train> trainList = new ArrayList<>();

    public TrainTimeAdapter(Context context, List<Train.ResultBean.ListBean> listBeans) {
        inflater = LayoutInflater.from(context);
        this.listBeans = listBeans;
    }

    public int getLayoutId() {
        return R.layout.train_time_recycle_item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(getLayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        itemHolder.bindHolder(listBeans.get(position));
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDepartureTime;
        private TextView mTvStopTime;
        private TextView mTvArrivalTime;
        private TextView mTvStation;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvArrivalTime = itemView.findViewById(R.id.tv_arrival_time);
            mTvStopTime = itemView.findViewById(R.id.tv_stop_time);
            mTvDepartureTime = itemView.findViewById(R.id.tv_departure_time);
            mTvStation = itemView.findViewById(R.id.tv_station);
        }

        public void bindHolder(Train.ResultBean.ListBean listBean) {
            //time.setText(train.getResult().getList().get(0).getArrivaltime()+"-"+train.getResult().getList().get(0).getDeparturetime());
            //station.setText(train.getResult().getList().get(0).getStation());
            mTvArrivalTime.setText(listBean.getArrivaltime());
            mTvStopTime.setText(listBean.getStoptime());
            mTvDepartureTime.setText(listBean.getDeparturetime());
            mTvStation.setText(listBean.getStation());
            //time.setText(listBean.getDeparturetime()+""+listBean.getArrivaltime());
            //station.setText(listBean.getStation());
        }
    }
}














