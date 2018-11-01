package com.example.trainschedule.widget.adapter;

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

public class TrainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private List<Station.ResultBean> resultBeans=new ArrayList<>();

    //声明接口变量
    private OnItemClickListener itemClickListener=null;

    public TrainAdapter(Context context,List<Station.ResultBean> resultBeans){
        inflater=LayoutInflater.from(context);
        this.resultBeans=resultBeans;
    }

    public int getLayoutId() {
        return R.layout.item_train;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new TrainAdapter.ViewHolder(inflater.inflate(R.layout.item_train,parent,false));
    }

    //将数据与界面进行绑定操作
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder,final int position){
        TrainAdapter.ViewHolder itemHolder=(TrainAdapter.ViewHolder)holder;
        itemHolder.bindHolder(resultBeans.get(position));

        //点击事件注册及分发
        if(null!=itemClickListener){
            //监听整个item
            ((ViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    itemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    //获取数据的数量
    @Override
    public int getItemCount(){
        return resultBeans.size();
    }

    //定义点击事件接口
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    //设置点击事件
    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView departure_time;
        private TextView departure_station;
        private TextView costTime;
        private TextView trainNo;
        private TextView arrival_time;
        private TextView arrival_station;
        private TextView price;
        private TextView seat_type;

        public ViewHolder(View itemView){
            super(itemView);
            departure_time=itemView.findViewById(R.id.departure_time);
            departure_station=itemView.findViewById(R.id.departure_station);
            costTime=itemView.findViewById(R.id.costTime);
            trainNo=itemView.findViewById(R.id.trainNo);
            arrival_time=itemView.findViewById(R.id.arrival_time);
            arrival_station=itemView.findViewById(R.id.arrival_station);
            price=itemView.findViewById(R.id.price);
            seat_type=itemView.findViewById(R.id.seat_type);
        }

        public void bindHolder(Station.ResultBean resultBean){
            departure_time.setText(resultBean.getDeparturetime());
            departure_station.setText(resultBean.getStation());
            costTime.setText(resultBean.getCosttime());
            trainNo.setText(resultBean.getTrainno());
            arrival_time.setText(resultBean.getArrivaltime());
            arrival_station.setText(resultBean.getEndstation());
            price.setText(resultBean.getPriceed());
            seat_type.setText(resultBean.getType());
        }
    }
}
