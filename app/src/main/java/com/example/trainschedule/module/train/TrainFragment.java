package com.example.trainschedule.module.train;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.utils.TextUtils;

import butterknife.BindView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class TrainFragment extends BaseFragment {
    private static final String TAG = "TrainFragment";

    //Fragment管理对象
    public FragmentManager manager;
    public FragmentTransaction ft;

    //搜索车次输入框
    @BindView(R.id.search_train_input)
    EditText search_train_input;
    //删除搜索车次输入框输入的内容
    @BindView(R.id.search_train_clear)
    ImageView search_train_clear;
    //搜索车次按钮
    @BindView(R.id.search_train_button)
    Button search_train_button;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_train;
    }

    @Override
    protected void initView(View view) {
        //监控EditText输入内容，点击clear图标删除输入内容
        TextUtils.addClearListener(search_train_input,search_train_clear);

        //输入法完成/回车
        search_train_input.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v,int keyCode,KeyEvent event){
                if(keyCode==android.view.KeyEvent.KEYCODE_ENTER&&event.getAction()==android.view.KeyEvent.ACTION_DOWN){
                    //获取输入的内容
                    String content=search_train_input.getText().toString();
                    //输出输入的内容
                    System.out.println("搜索内容："+content);

                    //使用Intent进行传值页面跳转
                    Intent intent=new Intent();
                    intent.setClass(TrainFragment.this.getActivity(),TrainResultActivity.class);
                    intent.putExtra("key",content);
                    TrainFragment.this.getActivity().startActivity(intent);
                }
                return false;
            }
        });

        //点击搜索按钮
        search_train_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //获取输入的内容
                String content=search_train_input.getText().toString();
                //输出输入的内容
                System.out.println("搜索内容："+content);

                //使用Intent进行传值页面跳转
                Intent intent=new Intent();
                intent.setClass(TrainFragment.this.getActivity(),TrainResultActivity.class);
                intent.putExtra("key",content);
                TrainFragment.this.getActivity().startActivity(intent);

            }
        });
    }
}


























