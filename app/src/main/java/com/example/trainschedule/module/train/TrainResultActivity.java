package com.example.trainschedule.module.train;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trainschedule.utils.ActionBarUtils;
import com.example.trainschedule.module.train.adapter.TrainTimeAdapter;
import com.example.trainschedule.bean.Train;
import com.example.trainschedule.R;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 * </pre>
 */

public class TrainResultActivity extends AppCompatActivity{
    private static final String TAG = "TrainResultActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.train_timeline)
    public RecyclerView mRvTrainTimeLine;
    private AlertDialog alertDialog;

    private List<Train.ResultBean.ListBean> listBeans=new ArrayList<>();
    private TrainTimeAdapter mTrainTimeAdapter;

    //车次
    @BindView(R.id.train_no)
    public TextView mTvTrainNo;
    //类型
    @BindView(R.id.train_type)
    public TextView mTvTrainType;
    //起点站
    @BindView(R.id.start_station)
    public TextView mTvStartStation;
    //起点时间
    @BindView(R.id.start_time)
    public TextView mTvStartTime;
    //终点站
    @BindView(R.id.end_station)
    public TextView mTvEndStation;
    //终点时间
    @BindView(R.id.end_time)
    public TextView mTvEndTime;
    //二维码
    @BindView(R.id.QRCode)
    public ImageView mIvQRCode;

    //请求接口
    private String url;

    private String mKeyStartStation;
    private String mKeyEndStation;
    private String mKeyStartTime;
    private String mKeyEndTime;

    //二维码文字
    private String mQRCodeText;

    public int getLayoutId() {
        return R.layout.train_result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        //Toolbar转化为ActionBar
        ActionBarUtils.setToolBar(this, toolbar, R.drawable.ic_menu, false);

        //获得Intent传递过来的值，并且将其所包含的空格去掉
        Intent intent=getIntent();
        String key=intent.getStringExtra("key");
        mKeyStartStation=intent.getStringExtra("start_station");
        if(mKeyStartStation!=null){
            mKeyStartStation=mKeyStartStation.replaceAll(""," ");
        }
        mKeyEndStation=intent.getStringExtra("end_station");
        if(mKeyEndStation!=null){
            mKeyEndStation=mKeyEndStation.replaceAll(""," ");
        }
        mKeyStartTime=intent.getStringExtra("start_time");
        if(mKeyStartTime!=null){
            mKeyStartTime=mKeyStartTime.replaceAll(""," ");
        }
        mKeyEndTime=intent.getStringExtra("end_time");
        if(mKeyEndTime!=null){
            mKeyEndTime=mKeyEndTime.replaceAll(""," ");
        }

        //查看传递过来的值
        //System.out.println(key);

        //极速数据api
        url=R.string.jisu_url_train+"&trainno="+key;

        getData();
    }

    //对Toolbar的菜单选项进行监听回调
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                //点击返货箭头返回上一页面
                //返回操作方法
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //获取数据
    private void getData(){
        //创建请求对象
        //使用Volley框架
        StringRequest request=new StringRequest(url,new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                Log.e("接受的响应信息",response);
                dealData(response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(TrainResultActivity.this,"网络请求出错",Toast.LENGTH_SHORT).show();
            }
        });
        //把请求对象加入请求队列里面
        new Volley().newRequestQueue(getApplicationContext()).add(request);
    }

    //处理数据
    private void dealData(String result){
        //实例化Gson对象
        Gson gson=new Gson();

        try{
            //把json字符转化为对象
            Train train=gson.fromJson(result,Train.class);

            //车次
            mTvTrainNo.setText(train.getResult().getTrainno());
            //类别
            mTvTrainType.setText(train.getResult().getType());
            //如果传过来的intent值不为空，则说明是从点击列车班次跳转过来的
            if(mKeyStartTime!=null&&mKeyEndTime!=null&&mKeyStartStation!=null&&mKeyEndStation!=null){
                //出发车站
                mTvStartStation.setText(mKeyStartStation);
                //出发时间
                mTvStartTime.setText(mKeyStartTime);
                //到达车站
                mTvEndStation.setText(mKeyEndStation);
                //到达时间
                mTvEndTime.setText(mKeyEndTime);
                //二维码文字
                mQRCodeText=mKeyStartStation+"->"+mKeyEndStation;
            }
            else{
                //起点站
                mTvStartStation.setText(train.getResult().getList().get(0).getStation());
                //起点时间
                mTvStartTime.setText(train.getResult().getList().get(0).getDeparturetime());
                //终点站
                mTvEndStation.setText(train.getResult().getList().get(train.getResult().getList().size()-1).getStation());
                //终点时间
                mTvEndTime.setText(train.getResult().getList().get(train.getResult().getList().size()-1).getArrivaltime());
                //二维码文字
                mQRCodeText=train.getResult().getList().get(0).getStation()+"—>"+train.getResult().getList().get(train.getResult().getList().size()-1).getStation();
            }

            for(int i=0;i<train.getResult().getList().size();i++){
                if(train.getResult().getList().get(i).getArrivaltime().equals("----")){
                    //Toast.makeText(TrainResultActivity.this,"测试1",Toast.LENGTH_SHORT).show();
                    listBeans.add(new Train.ResultBean.ListBean(
                            train.getResult().getList().get(i).getStation(),
                            train.getResult().getList().get(i).getDeparturetime(),
                            "",
                            ""));
                }
                else{
                    //Toast.makeText(TrainResultActivity.this,"测试2",Toast.LENGTH_SHORT).show();
                    listBeans.add(new Train.ResultBean.ListBean(
                            train.getResult().getList().get(i).getStation(),
                            train.getResult().getList().get(i).getArrivaltime()+"-",
                            train.getResult().getList().get(i).getStoptime()+"'",
                            "-"+train.getResult().getList().get(i).getDeparturetime()));
                }

            }

            //生成二维码
            Bitmap bitmap=null;
            try{
                //根据二维码文字生成二维码图片
                bitmap=BitmapUtils.create2DCode(mQRCodeText);
                mIvQRCode.setImageBitmap(bitmap);
            }catch(WriterException e){
                e.printStackTrace();
            }
        }catch(Exception e){
            //创建AlertDialog的构造器对象
            AlertDialog.Builder builder=new AlertDialog.Builder(TrainResultActivity.this);
            //设置构造器标题
            //builder.setTitle("错误");
            //构造器内容。为对话框设置文本项
            builder.setMessage(R.string.wrong_train);
            //为构造器设置确定按钮，第一个参数为按钮显示的文本信息，第二个参数为点击后的监听事件
            builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                //第一个参数dialog是点击的确定按钮所属的dialog对象，第二个对象which是按钮的标示值
                @Override
                public void onClick(DialogInterface dialog,int which){
                    onBackPressed();
                    //Toast.makeText(TrainResultActivity.this,"输入数据有误",Toast.LENGTH_SHORT).show();
                }
            });
            //利用构造器创建AlertDialog对象，实现实例化
            alertDialog=builder.create();
            if(alertDialog!=null&&!alertDialog.isShowing()){
                alertDialog.show();
            }
        }

        mTrainTimeAdapter=new TrainTimeAdapter(this,listBeans);
        mRvTrainTimeLine.setLayoutManager(new LinearLayoutManager(this));
        mRvTrainTimeLine.setAdapter(mTrainTimeAdapter);
    }

}


















