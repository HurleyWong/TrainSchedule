package com.example.trainschedule.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.core.activity.TrainResultActivity;
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

    /**
     * 搜索车次输入框
     */
    @BindView(R.id.et_train_input)
    EditText mEtTrainInput;
    /**
     * 删除搜索车次输入框输入的内容
     */
    @BindView(R.id.iv_train_clear)
    ImageView mIvTrainClear;
    /**
     * 搜索车次按钮
     */
    @BindView(R.id.btn_train_search)
    Button mBtnSearch;

    public static TrainFragment newInstance() {
        Bundle args = new Bundle();
        TrainFragment fragment = new TrainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_train;
    }

    @Override
    protected void initView(View view) {
        //监控EditText输入内容，点击clear图标删除输入内容
        TextUtils.addClearListener(mEtTrainInput, mIvTrainClear);

        //输入法完成/回车
        mEtTrainInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == android.view.KeyEvent.KEYCODE_ENTER && event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    //获取输入的内容
                    String content = mEtTrainInput.getText().toString();

                    //使用Intent进行传值页面跳转
                    Intent intent = new Intent();
                    intent.setClass(TrainFragment.this.getActivity(), TrainResultActivity.class);
                    intent.putExtra("key", content);
                    TrainFragment.this.getActivity().startActivity(intent);
                }
                return false;
            }
        });

        //点击搜索按钮
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入的内容
                String content = mEtTrainInput.getText().toString();

                //使用Intent进行传值页面跳转
                Intent intent = new Intent();
                intent.setClass(TrainFragment.this.getActivity(), TrainResultActivity.class);
                intent.putExtra("key", content);
                TrainFragment.this.getActivity().startActivity(intent);

            }
        });
    }
}


























