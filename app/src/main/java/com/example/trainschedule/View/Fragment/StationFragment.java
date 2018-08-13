package com.example.trainschedule.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.trainschedule.R;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class StationFragment extends Fragment{
    //搜索出发车站输入框
    private EditText start_train_input;
    //搜索到达车站输入框
    private EditText end_train_input;
    //搜索按钮
    private Button search_station_button;

    private void initViews(){
        start_train_input=getActivity().findViewById(R.id.search_start_station_input);
        end_train_input=getActivity().findViewById(R.id.search_end_station_input);
        search_station_button=getActivity().findViewById(R.id.search_station_button);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_station,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initViews();

    }
}




























