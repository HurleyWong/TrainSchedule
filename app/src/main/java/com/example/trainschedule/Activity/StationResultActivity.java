package com.example.trainschedule.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trainschedule.Adapter.TrainAdapter;
import com.example.trainschedule.Model.Station;
import com.example.trainschedule.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/14
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class StationResultActivity extends AppCompatActivity implements TrainAdapter.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private List<Station.ResultBean> resultBeans=new ArrayList<>();
    private TrainAdapter trainAdapter;

    //请求接口
    private String url;
    //判断是否只搜索高铁
    private int bool;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.station_result);
        initViews();

        //Toolbar转化为ActionBar
        setToolbar();

        //获得Intent传递过来的值，并且将其所包含的空格去掉
        Intent intent=getIntent();
        String key1=intent.getStringExtra("key1").replaceAll(" ","");
        String key2=intent.getStringExtra("key2").replaceAll(" ","");
        bool=intent.getIntExtra("bool",0);

        url="http://api.jisuapi.com/train/station2s?appkey=f54b78afc15a12fc&start="+key1+"&end="+key2+"&ishigh="+bool;

        getData();
    }

    //初始化控件
    private void initViews(){
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.train_info);
    }

    //Toolbar转化为ActionBar
    public void setToolbar(){
        //将Toolbar转化为Actionbar
        setSupportActionBar(toolbar);
        //获取ActionBar
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            //隐藏actionBar
            //actionBar.hide();
            //设置左上角的按钮图标可以点击
            actionBar.setDisplayHomeAsUpEnabled(true);
            //是否显示标题
            actionBar.setDisplayShowTitleEnabled(true);
        }
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
                Toast.makeText(StationResultActivity.this,"网络请求出错",Toast.LENGTH_SHORT).show();
            }
        });
        //把请求对象加入请求队列里面
        new Volley().newRequestQueue(getApplicationContext()).add(request);
    }

    //处理数据
    private void dealData(String result){
        //实例化Gson对象
        Gson gson=new Gson();
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

        trainAdapter=new TrainAdapter(this,resultBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        trainAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(trainAdapter);
    }

    @Override
    public void onItemClick(View view,int position){
        String content=resultBeans.get(position).getTrainno();
        Intent intent=new Intent();
        intent.setClass(this,TrainResultActivity.class);
        intent.putExtra("key",content);
        StationResultActivity.this.startActivity(intent);
    }
}


















