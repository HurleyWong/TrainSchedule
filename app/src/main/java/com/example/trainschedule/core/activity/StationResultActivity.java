package com.example.trainschedule.core.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.core.adapter.TrainAdapter;
import com.example.trainschedule.bean.Station;
import com.example.trainschedule.R;
import com.example.trainschedule.http.OkHttpEngine;
import com.example.trainschedule.http.ResultCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Request;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 * </pre>
 */

public class StationResultActivity extends BaseActivity implements TrainAdapter.OnItemClickListener {
    private static final String TAG = "StationResultActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_train_info)
    RecyclerView mRvTrainInfo;

    private AlertDialog alertDialog;

    private List<Station.ResultBean.ListBean> listBeans = new ArrayList<>();
    private TrainAdapter mTrainAdapter;

    /**
     * 请求接口
     */
    private String url;
    /**
     * 判断是否只搜索高铁
     */
    private int isHigh;

    @Override
    protected int getLayoutId() {
        return R.layout.station_result_activity;
    }

    @Override
    protected void initView() {

        // 获得 Intent 传递过来的值，并且将其所包含的空格去掉
        Intent intent = getIntent();
        String key1 = intent.getStringExtra("key1").replaceAll(" ", "");
        String key2 = intent.getStringExtra("key2").replaceAll(" ", "");
        isHigh = intent.getIntExtra("bool", 0);

        // 极速数据 api
        url = getString(R.string.jisu_url_station) + "&start=" + key1 + "&end=" + key2 + "&ishigh=" + isHigh;

        getData();
    }

    /**
     * 显示返回键
     *
     * @return
     */
    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    /**
     * 获取数据
     */
    private void getData() {
        OkHttpEngine.getInstance().getAsynHttp(url, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(StationResultActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String str) throws IOException {
                Log.e("接受的响应信息", str);
                dealData(str);
                mTrainAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 处理数据
     *
     * @param result
     */
    private void dealData(String result) {
        // 实例化 Gson 对象
        Gson gson = new Gson();

        try {
            //把 json 字符转化为对象
            Station station = gson.fromJson(result, Station.class);

            for (int i = 0; i < station.getResult().getList().size(); i++) {
                // 如果价格不为 0 且时间不为 0
                // 如果硬座价格不为空，则为硬座
                if (station.getResult().getList().get(i).getPriceyz() != null &&
                        !station.getResult().getList().get(i).getCosttime().equals("0分")) {
                    listBeans.add(new Station.ResultBean.ListBean(
                            station.getResult().getList().get(i).getTrainno(),
                            station.getResult().getList().get(i).getStation(),
                            station.getResult().getList().get(i).getEndstation(),
                            station.getResult().getList().get(i).getDeparturetime(),
                            station.getResult().getList().get(i).getArrivaltime(),
                            station.getResult().getList().get(i).getCosttime(),
                            station.getResult().getList().get(i).getPriceyz() + "元",
                            "硬座"
                    ));
                } else {
                    // 如果硬座价格为空，则为高铁
                    if (station.getResult().getList().get(i).getPriceed() != null) {
                        listBeans.add(new Station.ResultBean.ListBean(
                                station.getResult().getList().get(i).getTrainno(),
                                station.getResult().getList().get(i).getStation(),
                                station.getResult().getList().get(i).getEndstation(),
                                station.getResult().getList().get(i).getDeparturetime(),
                                station.getResult().getList().get(i).getArrivaltime(),
                                station.getResult().getList().get(i).getCosttime(),
                                station.getResult().getList().get(i).getPriceed() + "元",
                                "二等座"
                        ));
                    }
                }
            }
        } catch (Exception e) {
            // 创建 AlertDialog 的构造器对象
            AlertDialog.Builder builder = new AlertDialog.Builder(StationResultActivity.this);
            // 构造器内容。为对话框设置文本项
            builder.setMessage(R.string.wrong_station);
            // 为构造器设置确定按钮，第一个参数为按钮显示的文本信息，第二个参数为点击后的监听事件
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                // 第一个参数 dialog 是点击的确定按钮所属的dialog对象，第二个对象 which 是按钮的标示值
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onBackPressed();
                    // Toast.makeText(TrainResultActivity.this,"输入数据有误",Toast.LENGTH_SHORT).show();
                }
            });
            // 利用构造器创建 AlertDialog 对象，实现实例化
            alertDialog = builder.create();
            if (alertDialog != null && !alertDialog.isShowing()) {
                alertDialog.show();
            }
        }

        mRvTrainInfo.setLayoutManager(new LinearLayoutManager(this));
        // 为 RecyclerView 添加分割线
        mRvTrainInfo.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mTrainAdapter = new TrainAdapter(this, listBeans);
        mTrainAdapter.setOnItemClickListener(this);
        mRvTrainInfo.setAdapter(mTrainAdapter);

    }

    /**
     * RecyclerView 的 item 点击事件
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        String trainNp = listBeans.get(position).getTrainno();
        String startStation = listBeans.get(position).getStation();
        String endStation = listBeans.get(position).getEndstation();
        String startTime = listBeans.get(position).getDeparturetime();
        String endTime = listBeans.get(position).getArrivaltime();
        Intent intent = new Intent();
        intent.setClass(this, TrainResultActivity.class);
        intent.putExtra("key", trainNp);
        intent.putExtra("start_station", startStation);
        intent.putExtra("end_station", endStation);
        intent.putExtra("start_time", startTime);
        intent.putExtra("end_time", endTime);

        StationResultActivity.this.startActivity(intent);
    }
}


















