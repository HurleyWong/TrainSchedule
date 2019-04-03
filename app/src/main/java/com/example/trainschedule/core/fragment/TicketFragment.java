package com.example.trainschedule.core.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.example.trainschedule.R;
import com.example.trainschedule.api.ApiService;
import com.example.trainschedule.base.BaseFragment;
import com.example.trainschedule.bean.Ticket;
import com.example.trainschedule.core.adapter.TicketAdapter;
import com.example.trainschedule.http.RetrofitManager;
import com.huantansheng.easyphotos.EasyPhotos;
import com.huantansheng.easyphotos.models.album.entity.Photo;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String API_KEY = "9mCzvaOoj2UXZh7uOzAAXaoU";
    private static final String SECRET_KEY = "o16bD6cjKyIMFuCfw5WWSvZ3xffBGfV9";
    private static final String ACCESS_TOKEN = "24.3191cf02045daa9d80eb061ec15227c9.2592000.1556812741.282335-15913494";

    @BindView(R.id.tv_test)
    TextView mTvTest;
    @BindView(R.id.btn_photo)
    Button mBtnPhoto;
    @BindView(R.id.rv_ticket)
    RecyclerView mRvTicket;

    private TicketAdapter mAdapter;

    private ArrayList<Photo> photos = new ArrayList<>();

    private String image;

    /**
     * 授权成功
     */
    private static final int PERMISSION_GRANTED = 0;

    /**
     * 授权失败
     */
    private static final int PERMISSION_DENIED = 1;

    private static final int REQUEST_PERMISSIONN_CODE = 101;

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

                LogUtils.e(photos.get(0).path);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageUtils.getBitmap(photos.get(0).path).compress(Bitmap.CompressFormat.JPEG, 40, outputStream);
                byte[] bytes = outputStream.toByteArray();
                image = EncodeUtils.base64Encode2String(bytes);
                getTicket(image);
            }
        }

    }

    private void getAccessToken() {

    }

    @SuppressLint("CheckResult")
    private void getTicket(String image) {
        RetrofitManager.create(ApiService.class)
                .getTicket(ACCESS_TOKEN, image)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ticket>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ticket ticket) {
                        LogUtils.e(ticket.getWords_result().getStarting_station());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @SuppressLint("CheckResult")
    private void getWord(String image) {

    }

}
