package com.example.trainschedule.core.fragment;

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
    private static final String TAG = "DefaultFragment";

    @BindView(R.id.default_image)
    ImageView mIvDefault;

    private SimpleDraweeView draweeView;

    int resourceId=R.mipmap.small_railline;

    String url1="http://s16.sinaimg.cn/orignal/001yUN6jzy7hgWgzoHt0f&690";
    String url2="http://photo.blog.sina.com.cn/showpic.html#blogid=14f7d01f50102y18q&url=http://album.sina.com.cn/pic/0068URxzzy7mV6yvoio7c";

    @Override
    public int getLayoutId() {
        return R.layout.fragment_default;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this).load(resourceId).into(mIvDefault);
    }

}
