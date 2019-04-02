package com.example.trainschedule.core.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.core.adapter.TicketAdapter;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;


/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 3:07 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class TicketFragment extends BaseFragment {

    @BindView(R.id.tv_test)
    TextView mTvTest;
    @BindView(R.id.btn_photo)
    Button mBtnPhoto;
    @BindView(R.id.rv_ticket)
    RecyclerView mRvTicket;

    private TicketAdapter mAdapter;

    private ArrayList<Photo> photos = new ArrayList<>();


    /**
     * 授权成功
     */
    private static final int PERMISSION_GRANTED = 0;

    /**
     * 授权失败
     */
    private static final int PERMISSION_DENIED = 1;

    private static final int REQUEST_PERMISSIONN_CODE = 101;

    File mFile;
    Uri mImageUri;

    public static TicketFragment newInstance() {
        Bundle args = new Bundle();
        TicketFragment fragment = new TicketFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ticket;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new TicketAdapter(getContext(), photos);
        mRvTicket.setLayoutManager(linearLayoutManager);
        mRvTicket.setAdapter(mAdapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRvTicket);
    }

    @OnClick(R.id.btn_photo)
    public void onClick(View v) {
        EasyPhotos.createCamera(this)
                .setFileProviderAuthority("com.example.trainschedule.app.App")
                .start(REQUEST_PERMISSIONN_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_PERMISSIONN_CODE) {
                ArrayList<Photo> resultPhotos = data.getParcelableArrayListExtra(EasyPhotos.RESULT_PHOTOS);

                photos.clear();
                photos.addAll(resultPhotos);
                mAdapter.notifyDataSetChanged();
                mRvTicket.smoothScrollToPosition(0);
            }
        }

    }

}
