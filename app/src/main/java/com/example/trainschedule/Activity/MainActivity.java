package com.example.trainschedule.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.trainschedule.R;
import com.example.trainschedule.Util.ViewPagerSlide;
import com.example.trainschedule.View.Fragment.DefaultFragment;
import com.example.trainschedule.View.Fragment.StationFragment;
import com.example.trainschedule.View.Fragment.TrainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    //private ViewPager viewPager;
    private ViewPagerSlide viewPager;
    private AlertDialog alertDialog;

    private int option=-1;

    //车站查询
    //private StationFragment fragment1;
    //车次查询
    //private TrainFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //Toolbar转化为ActionBar
        setToolbar();
        //监听ViewPager
        viewPagerListener();
        //监听NavigationView
        navigationViewListener();
    }

    //初始化控件
    private void initViews(){
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewPager);
    }

    //顶部导航栏右边设置按钮
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }*/

    //Toolbar转化为ActionBar
    public void setToolbar(){
        //将Toolbar转化为Actionbar
        setSupportActionBar(toolbar);
        //获取ActionBar
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            //隐藏actionBar
            //actionBar.hide();
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
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
                //打开抽屉侧滑菜单
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //监听ViewPager
    public void viewPagerListener(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels){

            }

            @Override
            public void onPageSelected(int position){
                //滑动页面后的操作
            }

            @Override
            public void onPageScrollStateChanged(int state){

            }
        });

        //添加Fragment
        final ArrayList<Fragment> fragments=new ArrayList<>();
        //添加默认Fragment
        fragments.add(new DefaultFragment());
        //添加站站Fragment
        fragments.add(new StationFragment());
        //添加车次Fragment
        fragments.add(new TrainFragment());

        //设置适配器用于装载Fragment
        FragmentPagerAdapter pagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()){
            @Override
            public Fragment getItem(int position){
                //得到Fragment
                return fragments.get(position);
            }

            @Override
            public int getCount(){
                //得到数量
                return fragments.size();
            }
        };

        //设置装配器
        viewPager.setAdapter(pagerAdapter);
        //预加载剩下两页
        viewPager.setOffscreenPageLimit(2);
    }

    //监听NavigationView
    public void navigationViewListener(){
        if(navigationView!=null){
            navigationView.setNavigationItemSelectedListener(
                    //设置当导航栏被点击时的回调
                    new NavigationView.OnNavigationItemSelectedListener(){
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item){
                            switch(item.getItemId()){
                                //根据item进行选择
                                case R.id.station_query:
                                    //改变item选中状态
                                    item.setChecked(true);
                                    //跳转到相应的ViewPager
                                    //站站查询对应1
                                    viewPager.setCurrentItem(1);
                                    //禁止ViewPager左右滑动
                                    viewPager.setSlide(false);
                                    //Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    break;
                                case R.id.train_query:
                                    //改变item选中状态
                                    item.setChecked(true);
                                    //跳转到相应的ViewPager
                                    //车次查询对应2
                                    viewPager.setCurrentItem(2);
                                    //禁止ViewPager左右滑动
                                    viewPager.setSlide(false);
                                    //Toast.makeText(getApplicationContext(),item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    break;
                                case R.id.about:
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    //创建AlertDialog的构造器对象
                                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                    //设置构造器标题
                                    builder.setTitle("关于");
                                    //构造器内容。为对话框设置文本项
                                    builder.setMessage("作者：Hurley");
                                    //为构造器设置确定按钮，第一个参数为按钮显示的文本信息，第二个参数为点击后的监听事件
                                    builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                                        //第一个参数dialog是点击的确定按钮所属的dialog对象，第二个对象which是按钮的标示值
                                        @Override
                                        public void onClick(DialogInterface dialog,int which){
                                        }
                                    });
                                    //利用构造器创建AlertDialog对象，实现实例化
                                    alertDialog=builder.create();
                                    if(alertDialog!=null&&!alertDialog.isShowing()){
                                        alertDialog.show();
                                    }
                                    break;
                                case R.id.license:
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    Intent intent=new Intent();
                                    intent.setClass(MainActivity.this,LicenseActivity.class);
                                    MainActivity.this.startActivity(intent);
                                    break;
                            }
                            return false;
                        }
                    }
            );
        }
    }
}






















