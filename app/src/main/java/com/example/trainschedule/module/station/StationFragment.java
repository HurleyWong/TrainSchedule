package com.example.trainschedule.module.station;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.bean.StationTip;
import com.example.trainschedule.R;
import com.example.trainschedule.utils.TextUtils;
import com.example.trainschedule.utils.FileUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class StationFragment extends BaseFragment {
    private static final String TAG = "StationFragment";

    /**
     * 搜索出发车站输入框
     */
    @BindView(R.id.search_start_station_input)
    AutoCompleteTextView start_train_input;
    /**
     * 删除出发车站输入框输入的内容
     */
    @BindView(R.id.start_station_clear)
    ImageView start_station_clear;
    /**
     * 搜索到达车站输入框
     */
    @BindView(R.id.search_end_station_input)
    AutoCompleteTextView end_train_input;
    /**
     * 删除到达车站输入框输入的内容
     */
    @BindView(R.id.end_station_clear)
    ImageView end_station_clear;
    /**
     * 选择是否只搜索高铁
     */
    @BindView(R.id.isHigh)
    CheckBox checkBox;
    /**
     * 搜索按钮
     */
    @BindView(R.id.search_station_button)
    Button search_station_button;

    //请求接口
    private String url;

    private List<String> resultBeans=new ArrayList<String>();

    /**
     * 判断CheckBox是否被选中
     */
    private int isHigh=0;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_station;
    }

    @Override
    protected void initView(View view) {
        url=getString(R.string.afanda_url_station_tip) + getString(R.string.afanda_station_tip_key);
        //getData();
        dealData();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(StationFragment.this.getActivity(),android.R.layout.simple_list_item_1,resultBeans);

        //AutoCompleteTextView
        start_train_input.setAdapter(adapter);
        end_train_input.setAdapter(adapter);

        //监控EditText输入内容，点击clear图标删除输入内容
        TextUtils.addClearListener(start_train_input,start_station_clear);
        TextUtils.addClearListener(end_train_input,end_station_clear);

        //输入法完成/回车
        end_train_input.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view,int i,KeyEvent keyEvent){
                if(i==android.view.KeyEvent.KEYCODE_ENTER&&keyEvent.getAction()==android.view.KeyEvent.ACTION_DOWN){
                    //获取输入的内容
                    String start_station=start_train_input.getText().toString();
                    String end_station=end_train_input.getText().toString();
                    //输出输入的内容
                    System.out.println("出发车站："+start_station);
                    System.out.println("到达车站："+end_station);

                    //使用Intent进行传值页面跳转
                    Intent intent=new Intent();
                    intent.setClass(StationFragment.this.getActivity(),StationResultActivity.class);
                    intent.putExtra("key1",start_station);
                    intent.putExtra("key2",end_station);
                    StationFragment.this.getActivity().startActivity(intent);
                }
                return false;
            }
        });

        //点击搜索按钮
        search_station_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //获取输入的内容
                String start_station=start_train_input.getText().toString();
                String end_station=end_train_input.getText().toString();
                //输出输入的内容
                System.out.println("出发车站："+start_station);
                System.out.println("到达车站："+end_station);

                //设置CheckBox的监听事件，判断CheckBox是否被选中
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                        if(isChecked){
                            isHigh=1;
                        }
                        else{
                            isHigh=0;
                        }
                    }
                });

                //使用Intent进行传值页面跳转
                Intent intent=new Intent();
                intent.setClass(StationFragment.this.getActivity(),StationResultActivity.class);
                intent.putExtra("key1",start_station);
                intent.putExtra("key2",end_station);
                intent.putExtra("bool",isHigh);
                StationFragment.this.getActivity().startActivity(intent);
            }
        });
    }

    /**
     * 处理本地数据
     */
    private void dealData(){
        Gson gson=new Gson();
        String JSONContext= FileUtils.getJSON("station.json",getContext());
        final StationTip stationTip=gson.fromJson(JSONContext,StationTip.class);
        for(int i=0;i<stationTip.getResult().size();i++){
            resultBeans.add(stationTip.getResult().get(i).getName());
        }
    }

}




























