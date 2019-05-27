package com.example.trainschedule.core.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.trainschedule.bean.Token;
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
 *      desc    : 车票管理页面
 * </pre>
 */
public class TicketFragment extends BaseFragment {

    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String API_KEY = "9mCzvaOoj2UXZh7uOzAAXaoU";
    private static final String SECRET_KEY = "o16bD6cjKyIMFuCfw5WWSvZ3xffBGfV9";
    private static final String ACCESS_TOKEN = "24.d99aa7e58b61fd626b5293831b57a4ff.2592000.1560390146.282335-15913494";

    @BindView(R.id.tv_ticket_num)
    TextView mTvTicketNum;
    @BindView(R.id.tv_start_station)
    TextView mTvStartStation;
    @BindView(R.id.tv_ticket_date)
    TextView mTvTicketDate;
    @BindView(R.id.tv_ticket_price)
    TextView mTvTicketPrice;
    @BindView(R.id.tv_end_station)
    TextView mTvEndStation;
    @BindView(R.id.tv_seat_type)
    TextView mTvSeatType;
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
        return R.layout.ticket_fragment;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new TicketAdapter(getContext(), photos);
        mRvTicket.setLayoutManager(linearLayoutManager);
        mRvTicket.setAdapter(mAdapter);
//        SnapHelper snapHelper = new PagerSnapHelper();
//        snapHelper.attachToRecyclerView(mRvTicket);
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
        RetrofitManager.create(ApiService.class)
                .getAccessToken(CLIENT_CREDENTIALS, API_KEY, SECRET_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Token>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Token token) {

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
                        mTvTicketNum.setText(ticket.getWords_result().getTicket_num());
                        mTvStartStation.setText(ticket.getWords_result().getStarting_station());
                        mTvTicketDate.setText(ticket.getWords_result().getDate());
                        mTvTicketPrice.setText(ticket.getWords_result().getTicket_rates());
                        mTvEndStation.setText(ticket.getWords_result().getDestination_station());
                        mTvSeatType.setText(ticket.getWords_result().getSeat_category());
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
