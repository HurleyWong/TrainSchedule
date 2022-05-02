package com.example.trainschedule.core.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.core.adapter.TrainTimeAdapter;
import com.example.trainschedule.bean.Train;
import com.example.trainschedule.R;
import com.example.trainschedule.http.OkHttpEngine;
import com.example.trainschedule.http.ResultCallback;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Request;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class TrainResultActivity extends BaseActivity {
    private static final String TAG = "TrainResultActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_train_timeline)
    RecyclerView mRvTrainTimeLine;

    private AlertDialog alertDialog;

    private List<Train.ResultBean.ListBean> listBeans = new ArrayList<>();
    private TrainTimeAdapter mTrainTimeAdapter;

    /**
     * 车次
     */
    @BindView(R.id.tv_train_no)
    TextView mTvTrainNo;
    /**
     * 类型
     */
    @BindView(R.id.tv_train_type)
    TextView mTvTrainType;
    /**
     * 起点站
     */
    @BindView(R.id.tv_start_station)
    TextView mTvStartStation;
    /**
     * 起点时间
     */
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    /**
     * 终点站
     */
    @BindView(R.id.tv_end_station)
    TextView mTvEndStation;
    /**
     * 终点时间
     */
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    /**
     * 二维码
     */
    @BindView(R.id.iv_QR_code)
    ImageView mIvQRCode;

    /**
     * 请求接口
     */
    private String url;

    private String mKeyStartStation;
    private String mKeyEndStation;
    private String mKeyStartTime;
    private String mKeyEndTime;

    /**
     * 二维码文字
     */
    private String mQRCodeText;

    @Override
    protected int getLayoutId() {
        return R.layout.train_result_activity;
    }

    @Override
    protected void initView() {
        // 获得 Intent 传递过来的值，并且将其所包含的空格去掉
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        mKeyStartStation = intent.getStringExtra("start_station");
        if (mKeyStartStation != null) {
            mKeyStartStation = mKeyStartStation.replaceAll("", " ");
        }
        mKeyEndStation = intent.getStringExtra("end_station");
        if (mKeyEndStation != null) {
            mKeyEndStation = mKeyEndStation.replaceAll("", " ");
        }
        mKeyStartTime = intent.getStringExtra("start_time");
        if (mKeyStartTime != null) {
            mKeyStartTime = mKeyStartTime.replaceAll("", " ");
        }
        mKeyEndTime = intent.getStringExtra("end_time");
        if (mKeyEndTime != null) {
            mKeyEndTime = mKeyEndTime.replaceAll("", " ");
        }

        url = getString(R.string.jisu_url_train) + "&trainno=" + key;

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
                Toast.makeText(TrainResultActivity.this, "网络请求错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String str) throws IOException {
                Log.e("接受的响应信息", str);
                dealData(str);
            }
        });
    }

    /**
     * 处理数据
     *
     * @param result
     */
    private void dealData(String result) {
        //实例化 Gson 对象
        Gson gson = new Gson();

        try {
            //把 json 字符转化为对象
            Train train = gson.fromJson(result, Train.class);

            // 车次
            mTvTrainNo.setText(train.getResult().getTrainno());
            // 类别
            mTvTrainType.setText(train.getResult().getTypename());
            // 如果传过来的 intent 值不为空，则说明是从点击列车班次跳转过来的
            if (mKeyStartTime != null && mKeyEndTime != null && mKeyStartStation != null && mKeyEndStation != null) {
                // 出发车站
                mTvStartStation.setText(mKeyStartStation);
                // 出发时间
                mTvStartTime.setText(mKeyStartTime);
                // 到达车站
                mTvEndStation.setText(mKeyEndStation);
                // 到达时间
                mTvEndTime.setText(mKeyEndTime);
                // 二维码文字
                mQRCodeText = mKeyStartStation + "->" + mKeyEndStation;
            } else {
                // 起点站
                mTvStartStation.setText(train.getResult().getList().get(0).getStation());
                // 起点时间
                mTvStartTime.setText(train.getResult().getList().get(0).getDeparturetime());
                // 终点站
                mTvEndStation.setText(train.getResult().getList().get(train.getResult().getList().size() - 1).getStation());
                // 终点时间
                mTvEndTime.setText(train.getResult().getList().get(train.getResult().getList().size() - 1).getArrivaltime());
                // 二维码文字
                mQRCodeText = train.getResult().getList().get(0).getStation() + "—>" + train.getResult().getList().get(train.getResult().getList().size() - 1).getStation();
            }

            for (int i = 0; i < train.getResult().getList().size(); i++) {
                if (train.getResult().getList().get(i).getArrivaltime().equals("----")) {
                    listBeans.add(new Train.ResultBean.ListBean(
                            train.getResult().getList().get(i).getStation(),
                            train.getResult().getList().get(i).getDeparturetime(),
                            "",
                            ""));
                } else {
                    listBeans.add(new Train.ResultBean.ListBean(
                            train.getResult().getList().get(i).getStation(),
                            train.getResult().getList().get(i).getArrivaltime(),
                            train.getResult().getList().get(i).getStoptime() + "'",
                            train.getResult().getList().get(i).getDeparturetime()));
                }

            }

            // 生成二维码
            Bitmap bitmap = null;
            try {
                // 根据二维码文字生成二维码图片
                bitmap = BitmapUtils.create2DCode(mQRCodeText);
                mIvQRCode.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // 创建 AlertDialog 的构造器对象
            AlertDialog.Builder builder = new AlertDialog.Builder(TrainResultActivity.this);
            // 构造器内容。为对话框设置文本项
            builder.setMessage(R.string.wrong_train);
            // 为构造器设置确定按钮，第一个参数为按钮显示的文本信息，第二个参数为点击后的监听事件
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                // 第一个参数 dialog 是点击的确定按钮所属的 dialog 对象，第二个对象 which 是按钮的标示值
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

        mTrainTimeAdapter = new TrainTimeAdapter(this, listBeans);
        mRvTrainTimeLine.setLayoutManager(new LinearLayoutManager(this));
        mRvTrainTimeLine.setAdapter(mTrainTimeAdapter);
    }

}


















