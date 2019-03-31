package com.example.trainschedule.module.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.example.trainschedule.utils.ActionBarUtils;
import com.example.trainschedule.module.activity.adapter.LicenseAdapter;
import com.example.trainschedule.bean.License;
import com.example.trainschedule.R;
import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/08/16
 * </pre>
 */

public class LicenseActivity extends AppCompatActivity{
    private static final String TAG = "LicenseActivity";

    @BindView(R.id.drawerLayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.license_info)
    public RecyclerView mRvLicenseInfo;

    private List<License> licenses=new ArrayList<>();
    private LicenseAdapter mLicenseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //initViews();
        ButterKnife.bind(this);

        //Toolbar转化为ActionBar
        ActionBarUtils.setToolBar(this, toolbar, R.drawable.ic_menu, false);

        //添加RecyclerView的数据
        dealData(this);
    }

    public int getLayoutId() {
        return R.layout.fragment_license;
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

    private void dealData(Context context){
        //添加所使用的开源项目的名称和地址
        licenses.add(new License(getString(R.string.Gson),getString(R.string.gson_addr)));
        licenses.add(new License(getString(R.string.Volley),getString(R.string.volley_addr)));
        licenses.add(new License(getString(R.string.Glide),getString(R.string.glide_addr)));
        licenses.add(new License(getString(R.string.Fresco),getString(R.string.fresco_addr)));
        licenses.add(new License(getString(R.string.BufferKnife),getString(R.string.butterknife_addr)));
        licenses.add(new License(getString(R.string.PinchImageView),getString(R.string.pinchimageview_addr)));
        licenses.add(new License(getString(R.string.FlyShapeImageView),getString(R.string.flyshapeimageview_addr)));
        licenses.add(new License(getString(R.string.Y_DividerItemDecoration),getString(R.string.y_divideritemdecoration_addr)));
        licenses.add(new License(getString(R.string.Zxing),getString(R.string.zxing_addr)));

        mLicenseAdapter=new LicenseAdapter(this,licenses);
        mRvLicenseInfo.setLayoutManager(new LinearLayoutManager(this));
        //为RecyclerView添加分割线
        mRvLicenseInfo.addItemDecoration(new DividerItemDecoration(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //默认添加分割线方式
        //recyclerView.addItemDecoration(new RecyclerViewDivider(context,LinearLayoutManager.VERTICAL,R.drawable.a_divider_bg));
        mRvLicenseInfo.setAdapter(mLicenseAdapter);
    }

    //RecyclerView的分割线
    //使用Y_DividerItemDecoration框架
    private class DividerItemDecoration extends Y_DividerItemDecoration{

        private DividerItemDecoration(Context context){
            super(context);
        }

        @Override
        public Y_Divider getDivider(int itemPosition){
            Y_Divider divider=null;
            switch(itemPosition%2){
                case 0:
                    //每一行第一个显示right和bottom
                    divider=new Y_DividerBuilder()
                            //.setRightSideLine(true,0xff666666,10,0,0)
                            .setBottomSideLine(true,getResources().getColor(R.color.y_divider),1,0,0)
                            .create();
                    break;
                case 1:
                    //每一行第二个显示left和bottom
                    divider=new Y_DividerBuilder()
                            //.setLeftSideLine(true,0xff666666,10,0,0)
                            .setBottomSideLine(true,getResources().getColor(R.color.y_divider),1,0,0)
                            .create();
                    break;
                default:
                    break;
            }
            //第一行上方显示分割线
            if(itemPosition==0){
                divider=new Y_DividerBuilder()
                        .setTopSideLine(true,getResources().getColor(R.color.y_divider),1,0,0)
                        .setBottomSideLine(true,getResources().getColor(R.color.y_divider),1,0,0)
                        .create();
            }
            return divider;
        }
    }
}




















