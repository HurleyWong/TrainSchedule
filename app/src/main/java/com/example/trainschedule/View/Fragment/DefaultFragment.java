package com.example.trainschedule.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

public class DefaultFragment extends Fragment{

    private ImageView default_image;

    //初始化控件
    private void initViews(){
        default_image=getActivity().findViewById(R.id.default_image);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_default,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initViews();

    }
}
