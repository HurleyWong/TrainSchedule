package com.example.trainschedule.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.trainschedule.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


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
    private static final String TAG = "DefaultFragment";

    private ImageView default_image;

    private SimpleDraweeView draweeView;

    int resourceId=R.mipmap.small_railline;

    String url1="http://s16.sinaimg.cn/orignal/001yUN6jzy7hgWgzoHt0f&690";
    String url2="http://photo.blog.sina.com.cn/showpic.html#blogid=14f7d01f50102y18q&url=http://album.sina.com.cn/pic/0068URxzzy7mV6yvoio7c";

    //初始化控件
    private void initViews(){
        default_image=getActivity().findViewById(R.id.default_image);
        //draweeView = getActivity().findViewById(R.id.default_image);
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

        //Fresco加载图片
        //Uri uri = Uri.parse("res://mipmap/"+R.mipmap.small_railline);
        //draweeView.setImageURI(uri);

        //Glide加载图片
        Glide.with(this).load(resourceId).into(default_image);
    }

}
