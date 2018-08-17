package com.example.trainschedule.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
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
import com.example.trainschedule.Adapter.TrainTimeAdapter;
import com.example.trainschedule.Model.Train;
import com.example.trainschedule.R;
import com.google.gson.Gson;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/13
 *      desc   :
 *      version: 1.0
 *  </pre>
 */

public class TrainResultActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private AlertDialog alertDialog;

    private List<Train.ResultBean.ListBean> listBeans=new ArrayList<>();
    private TrainTimeAdapter trainTimeAdapter;

    //车次
    private TextView train_no;
    //类型
    private TextView train_type;
    //起点站
    private TextView start_station;
    //起点时间
    private TextView start_time;
    //终点站
    private TextView end_station;
    //终点时间
    private TextView end_time;
    //二维码
    private ImageView QRCode;

    //请求接口
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_result);
        initViews();

        //Toolbar转化为ActionBar
        setToolbar();

        //获得Intent传递过来的值，并且将其所包含的空格去掉
        Intent intent=getIntent();
        String key=intent.getStringExtra("key").replaceAll(" ","");
        //查看传递过来的值
        //System.out.println(key);
        url="http://api.jisuapi.com/train/line?appkey=f54b78afc15a12fc&trainno="+key;

        getData();
    }

    //初始化控件
    private void initViews(){
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.train_timeline);

        train_no=findViewById(R.id.train_no);
        train_type=findViewById(R.id.train_type);
        start_station=findViewById(R.id.start_station);
        start_time=findViewById(R.id.start_time);
        end_station=findViewById(R.id.end_station);
        end_time=findViewById(R.id.end_time);
        QRCode=findViewById(R.id.QRCode);
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
            train_no.setText(train.getResult().getTrainno());
            //类别
            train_type.setText(train.getResult().getType());
            //起点站
            start_station.setText(train.getResult().getList().get(0).getStation());
            //起点时间
            start_time.setText(train.getResult().getList().get(0).getDeparturetime());
            //终点站
            end_station.setText(train.getResult().getList().get(train.getResult().getList().size()-1).getStation());
            //终点时间
            end_time.setText(train.getResult().getList().get(train.getResult().getList().size()-1).getArrivaltime());

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
            String QRCodeContent=train.getResult().getList().get(0).getStation()+"—>"+train.getResult().getList().get(train.getResult().getList().size()-1).getStation();
            Bitmap bitmap=null;
            try{
                bitmap=BitmapUtils.create2DCode(QRCodeContent);
                QRCode.setImageBitmap(bitmap);
            }catch(WriterException e){
                e.printStackTrace();
            }
        }catch(Exception e){
            //创建AlertDialog的构造器对象
            AlertDialog.Builder builder=new AlertDialog.Builder(TrainResultActivity.this);
            //设置构造器标题
            //builder.setTitle("错误");
            //构造器内容。为对话框设置文本项
            builder.setMessage("输入车次有误，请输入正确的车次");
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

        trainTimeAdapter=new TrainTimeAdapter(this,listBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(trainTimeAdapter);
    }

}


















