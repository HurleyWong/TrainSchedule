package com.example.trainschedule.View.Fragment;

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

import com.example.trainschedule.Activity.StationResultActivity;
import com.example.trainschedule.R;
import com.example.trainschedule.Util.EditTextClearUtil;

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
    private AutoCompleteTextView start_train_input;
    //删除出发车站输入框输入的内容
    private ImageView start_station_clear;
    //搜索到达车站输入框
    private AutoCompleteTextView end_train_input;
    //删除到达车站输入框输入的内容
    private ImageView end_station_clear;
    //选择是否只搜索高铁
    private CheckBox checkBox;
    //搜索按钮
    private Button search_station_button;

    //判断CheckBox是否被选中
    private int isHigh=0;

    private void initViews(){
        start_train_input=getActivity().findViewById(R.id.search_start_station_input);
        end_train_input=getActivity().findViewById(R.id.search_end_station_input);
        start_station_clear=getActivity().findViewById(R.id.start_station_clear);
        end_station_clear=getActivity().findViewById(R.id.end_station_clear);
        checkBox=getActivity().findViewById(R.id.isHigh);
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

        String[] strings=new String[]{
                "南昌","上饶","杭州东","上海虹桥"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(StationFragment.this.getActivity(),android.R.layout.simple_list_item_1,strings);

        //AutoCompleteTextView
        start_train_input.setAdapter(adapter);
        end_train_input.setAdapter(adapter);

        //监控EditText输入内容，点击clear图标删除输入内容
        EditTextClearUtil.addClearListener(start_train_input,start_station_clear);
        EditTextClearUtil.addClearListener(end_train_input,end_station_clear);

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
}




























