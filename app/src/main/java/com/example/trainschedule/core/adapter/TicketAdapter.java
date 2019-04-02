package com.example.trainschedule.core.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.trainschedule.R;
import com.example.trainschedule.core.fragment.TicketFragment;
import com.huantansheng.easyphotos.models.album.entity.Photo;

import java.util.ArrayList;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/2 5:00 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private ArrayList<Photo> photos;
    private LayoutInflater mInflater;
    private Context mContext;

    public TicketAdapter(Context context, ArrayList<Photo> photos) {
        this.photos = photos;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TicketViewHolder(mInflater.inflate(R.layout.item_ticket, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        Photo photo = photos.get(i);
        Glide.with(mContext).load(photo.path).into(ticketViewHolder.mIvPhoto);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class TicketViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvPhoto;

        TicketViewHolder(View itemView) {
            super(itemView);
            mIvPhoto = itemView.findViewById(R.id.iv_ticket);
        }
    }
}
