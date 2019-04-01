package com.example.trainschedule.module.station;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.module.train.adapter.TrainAdapter;
import com.example.trainschedule.bean.Station;
import com.example.trainschedule.R;
import com.example.trainschedule.module.train.TrainResultActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 * </pre>
 */

public class StationResultActivity extends BaseActivity implements TrainAdapter.OnItemClickListener{
    private static final String TAG = "StationResultActivity";

    @BindView(R.id.coordinator)
    public CoordinatorLayout coordinator;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.train_info)
    public RecyclerView recyclerView;
    private AlertDialog alertDialog;

    private List<Station.ResultBean> resultBeans=new ArrayList<>();
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
        return R.layout.activity_station_result;
    }

    @Override
    protected void initView() {
        //获得Intent传递过来的值，并且将其所包含的空格去掉
        Intent intent=getIntent();
        String key1=intent.getStringExtra("key1").replaceAll(" ","");
        String key2=intent.getStringExtra("key2").replaceAll(" ","");
        isHigh=intent.getIntExtra("bool",0);

        //极速数据api
        url=R.string.jisu_url_station+"&start="+key1+"&end="+key2+"&ishigh="+isHigh;

        getData();
    }

    /**
     * 获取数据
     */
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
                Toast.makeText(StationResultActivity.this,"网络请求出错",Toast.LENGTH_SHORT).show();
            }
        });
        //把请求对象加入请求队列里面
        Volley.newRequestQueue(getApplicationContext()).add(request);
    }

    /**
     * 处理数据
     * @param result
     */
    private void dealData(String result){
        //实例化Gson对象
        Gson gson=new Gson();

        try{
            //把json字符转化为对象
            final Station station=gson.fromJson(result,Station.class);

            for(int i=0;i<station.getResult().size();i++){
                if(station.getResult().get(i).getPriceyz()!=null){
                    resultBeans.add(new Station.ResultBean(
                            station.getResult().get(i).getTrainno(),
                            station.getResult().get(i).getStation(),
                            station.getResult().get(i).getEndstation(),
                            station.getResult().get(i).getDeparturetime(),
                            station.getResult().get(i).getArrivaltime(),
                            station.getResult().get(i).getCosttime(),
                            station.getResult().get(i).getPriceyz()+"元",
                            "硬座"

                    ));
                }
                else{
                    resultBeans.add(new Station.ResultBean(
                            station.getResult().get(i).getTrainno(),
                            station.getResult().get(i).getStation(),
                            station.getResult().get(i).getEndstation(),
                            station.getResult().get(i).getDeparturetime(),
                            station.getResult().get(i).getArrivaltime(),
                            station.getResult().get(i).getCosttime(),
                            station.getResult().get(i).getPriceed()+"元",
                            "二等座"
                    ));
                }
            }
        }catch(Exception e){
            //创建AlertDialog的构造器对象
            AlertDialog.Builder builder=new AlertDialog.Builder(StationResultActivity.this);
            //设置构造器标题
            //builder.setTitle("错误");
            //构造器内容。为对话框设置文本项
            builder.setMessage(R.string.wrong_station);
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


        mTrainAdapter=new TrainAdapter(this,resultBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //为RecyclerView添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mTrainAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mTrainAdapter);
    }

    /**
     * RecyclerView的item点击事件
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view,int position){
        String train_no=resultBeans.get(position).getTrainno();
        String start_station=resultBeans.get(position).getStation();
        String end_station=resultBeans.get(position).getEndstation();
        String start_time=resultBeans.get(position).getDeparturetime();
        String end_time=resultBeans.get(position).getArrivaltime();
        Intent intent=new Intent();
        intent.setClass(this,TrainResultActivity.class);
        intent.putExtra("key",train_no);
        intent.putExtra("start_station",start_station);
        intent.putExtra("end_station",end_station);
        intent.putExtra("start_time",start_time);
        intent.putExtra("end_time",end_time);

        StationResultActivity.this.startActivity(intent);
    }
}


















