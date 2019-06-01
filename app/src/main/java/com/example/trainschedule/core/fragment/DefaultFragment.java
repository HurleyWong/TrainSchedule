package com.example.trainschedule.core.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;


/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class DefaultFragment extends BaseFragment {

    @BindView(R.id.default_image)
    ImageView mIvDefault;

    private SimpleDraweeView draweeView;

    public static DefaultFragment newInstance() {
        Bundle args = new Bundle();
        DefaultFragment fragment = new DefaultFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.default_fragment;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this).
                load("https://raw.githubusercontent.com/HurleyJames/ImageHosting/master/small_railline.JPG").
                into(mIvDefault);
    }

}
