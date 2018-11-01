package com.example.trainschedule.widget.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trainschedule.bean.License;
import com.example.trainschedule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 * </pre>
 */

public class LicenseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    private List<License> licenses=new ArrayList<>();

    public LicenseAdapter(Context context,List<License> licenses){
        inflater=LayoutInflater.from(context);
        this.licenses=licenses;
    }

    public int getLayoutId() {
        return R.layout.item_license;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new LicenseAdapter.ViewHolder(inflater.inflate(getLayoutId(),parent,false));
    }

    //将数据与界面进行绑定操作
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
        LicenseAdapter.ViewHolder itemHolder=(LicenseAdapter.ViewHolder)holder;
        itemHolder.bindHolder(licenses.get(position));
    }

    //获取数据的数量
    @Override
    public int getItemCount(){
        return licenses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView license_name;
        private TextView license_link;

        public ViewHolder(View itemView){
            super(itemView);
            license_name=itemView.findViewById(R.id.license_name);
            license_link=itemView.findViewById(R.id.license_link);
        }

        public void bindHolder(License license){
            license_name.setText(license.getLicense_name());
            license_link.setText(license.getLicense_link());
        }
    }
}
