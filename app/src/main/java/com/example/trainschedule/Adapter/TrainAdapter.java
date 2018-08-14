package com.example.trainschedule.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainschedule.Model.Station;
import com.example.trainschedule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class TrainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private List<Station.ResultBean> resultBeans=new ArrayList<>();

    public TrainAdapter(Context context,List<Station.ResultBean> resultBeans){
        inflater=LayoutInflater.from(context);
        this.resultBeans=resultBeans;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new TrainAdapter.ViewHolder(inflater.inflate(R.layout.item_train,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
        TrainAdapter.ViewHolder itemHolder=(TrainAdapter.ViewHolder)holder;
        itemHolder.bindHolder(resultBeans.get(position));
    }

    @Override
    public int getItemCount(){
        return resultBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView departure_time;
        private TextView departure_station;
        private TextView costTime;
        private TextView trainNo;
        private TextView arrival_time;
        private TextView arrival_station;
        private TextView price;

        public ViewHolder(View itemView){
            super(itemView);
            departure_time=itemView.findViewById(R.id.departure_time);
            departure_station=itemView.findViewById(R.id.departure_station);
            costTime=itemView.findViewById(R.id.costTime);
            trainNo=itemView.findViewById(R.id.trainNo);
            arrival_time=itemView.findViewById(R.id.arrival_time);
            arrival_station=itemView.findViewById(R.id.arrival_station);
            price=itemView.findViewById(R.id.price);
        }

        public void bindHolder(Station.ResultBean resultBean){
            departure_time.setText(resultBean.getDeparturetime());
            departure_station.setText(resultBean.getStation());
            costTime.setText(resultBean.getCosttime());
            trainNo.setText(resultBean.getTrainno());
            arrival_time.setText(resultBean.getArrivaltime());
            arrival_station.setText(resultBean.getEndstation());
            price.setText(resultBean.getPriceed());
        }
    }
}
