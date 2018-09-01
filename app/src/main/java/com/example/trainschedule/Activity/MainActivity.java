package com.example.trainschedule.Activity;

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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.trainschedule.R;
import com.example.trainschedule.Util.ViewPagerSlide;
import com.example.trainschedule.View.Fragment.DefaultFragment;
import com.example.trainschedule.View.Fragment.StationFragment;
import com.example.trainschedule.View.Fragment.TrainFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    public NavigationView navigationView;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.viewPager)
    //private ViewPager viewPager;
    public ViewPagerSlide viewPager;

    private AlertDialog alertDialog;

    private long exitTime=0;

    private int option=-1;

    //车站查询
    //private StationFragment fragment1;
    //车次查询
    //private TrainFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initViews();
        ButterKnife.bind(this);

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
                                case R.id.default_fragment:
                                    //改变item选中状态
                                    item.setChecked(true);
                                    //跳转到相应的ViewPager
                                    //首页默认对应0
                                    viewPager.setCurrentItem(0);
                                    viewPager.setSlide(false);
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    break;
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
                                /*case R.id.ticket_manage:
                                    //改变item选中状态
                                    item.setChecked(true);
                                    //跳转到相应的ViewPager
                                    //车票管理对应3
                                    viewPager.setCurrentItem(3);
                                    //禁止ViewPager左右滑动
                                    viewPager.setSlide(false);
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    break;

                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    Intent intent1=new Intent();
                                    intent1.setClass(MainActivity.this,TicketActivity.class);
                                    MainActivity.this.startActivity(intent1);
                                    break;
                                */
                                case R.id.about:
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    Intent intent2=new Intent();
                                    intent2.setClass(MainActivity.this,AboutActivity.class);
                                    MainActivity.this.startActivity(intent2);
                                    break;
                                case R.id.license:
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    Intent intent3=new Intent();
                                    intent3.setClass(MainActivity.this,LicenseActivity.class);
                                    MainActivity.this.startActivity(intent3);
                                    break;
                                case R.id.support:
                                    //关闭导航栏菜单
                                    drawerLayout.closeDrawers();
                                    Intent intent4=new Intent();
                                    intent4.setClass(MainActivity.this,SupportActivity.class);
                                    MainActivity.this.startActivity(intent4);
                                    break;
                            }
                            return false;
                        }
                    }
            );
        }
    }

    //重写点击返回键事件
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }

    //按两次返回键退出程序
    private void exit(){
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(MainActivity.this,"再按一次返回键退出程序",Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();
        }
        else{
            finish();
            System.exit(0);
        }
    }

}






















