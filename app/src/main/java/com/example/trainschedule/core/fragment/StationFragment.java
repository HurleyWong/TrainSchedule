package com.example.trainschedule.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.bean.StationTip;
import com.example.trainschedule.R;
import com.example.trainschedule.core.activity.StationResultActivity;
import com.example.trainschedule.utils.TextUtils;
import com.example.trainschedule.utils.FileUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @BindView(R.id.tv_start_station_input)
    AutoCompleteTextView mTvStartStation;
    /**
     * 删除出发车站输入框输入的内容
     */
    @BindView(R.id.iv_start_station_clear)
    ImageView mIvStartStation;
    /**
     * 搜索到达车站输入框
     */
    @BindView(R.id.tv_end_station_input)
    AutoCompleteTextView mTvEndStation;
    /**
     * 删除到达车站输入框输入的内容
     */
    @BindView(R.id.iv_end_station_clear)
    ImageView mIvEndStation;
    /**
     * 选择是否只搜索高铁
     */
    @BindView(R.id.cb_is_high)
    CheckBox mCbIsHigh;
    /**
     * 搜索按钮
     */
    @BindView(R.id.btn_station_search)
    Button mBtnSearch;

    /**
     * 请求接口
     */
    private String url;

    private List<String> resultBeans = new ArrayList<>();

    /**
     * 判断 CheckBox 是否被选中
     */
    private int isHigh = 0;

    public static StationFragment newInstance() {
        Bundle args = new Bundle();
        StationFragment fragment = new StationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.station_fragment;
    }

    @Override
    protected void initView(View view) {
        url = getString(R.string.jisu_url_station);
        // getData();
        dealData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(StationFragment.this.getActivity()), android.R.layout.simple_list_item_1, resultBeans);

        // AutoCompleteTextView
        mTvStartStation.setAdapter(adapter);
        mTvEndStation.setAdapter(adapter);

        // 监控 EditText 输入内容，点击 clear 图标删除输入内容
        TextUtils.addClearListener(mTvStartStation, mIvStartStation);
        TextUtils.addClearListener(mTvEndStation, mIvEndStation);

        // 输入法完成/回车
        mTvEndStation.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == android.view.KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    // 获取输入的内容
                    String start_station = mTvStartStation.getText().toString();
                    String end_station = mTvEndStation.getText().toString();
                    // 输出输入的内容
                    System.out.println("出发车站：" + start_station);
                    System.out.println("到达车站：" + end_station);

                    // 使用 Intent 进行传值页面跳转
                    Intent intent = new Intent();
                    intent.setClass(StationFragment.this.getActivity(), StationResultActivity.class);
                    intent.putExtra("key1", start_station);
                    intent.putExtra("key2", end_station);
                    StationFragment.this.getActivity().startActivity(intent);
                }
                return false;
            }
        });

        // 点击搜索按钮
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入的内容
                String start_station = mTvStartStation.getText().toString();
                String end_station = mTvEndStation.getText().toString();

                // 设置 CheckBox 的监听事件，判断 CheckBox 是否被选中
                mCbIsHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            isHigh = 1;
                        } else {
                            isHigh = 0;
                        }
                    }
                });

                // 使用 Intent 进行传值页面跳转
                Intent intent = new Intent();
                intent.setClass(StationFragment.this.getActivity(), StationResultActivity.class);
                intent.putExtra("key1", start_station);
                intent.putExtra("key2", end_station);
                intent.putExtra("bool", isHigh);
                StationFragment.this.getActivity().startActivity(intent);
            }
        });
    }

    /**
     * 处理本地数据
     */
    private void dealData() {
        Gson gson = new Gson();
        String JSONContext = FileUtils.getJSON("station.json", getContext());
        final StationTip stationTip = gson.fromJson(JSONContext, StationTip.class);
        for (int i = 0; i < stationTip.getResult().size(); i++) {
            resultBeans.add(stationTip.getResult().get(i).getName());
        }
    }

}




























