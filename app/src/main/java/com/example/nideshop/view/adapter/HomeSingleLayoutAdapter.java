package com.example.nideshop.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nideshop.R;
import com.example.nideshop.bean.HomeBean;

import java.util.ArrayList;

public class HomeSingleLayoutAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topiclist;
    private LinearLayoutHelper singleLayoutHelper;

    public HomeSingleLayoutAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topiclist, LinearLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.topiclist = topiclist;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_topic, parent, false);
        return new SingleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleViewHolder singleViewHolder = (SingleViewHolder) holder;
        singleViewHolder.rv_topic.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        TopicAdapter topicAdapter = new TopicAdapter(context, topiclist,singleLayoutHelper);
        singleViewHolder.rv_topic.setAdapter(topicAdapter);
        //topicAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class SingleViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_topic;

        public SingleViewHolder(View inflate) {
            super(inflate);
            rv_topic = inflate.findViewById(R.id.rv_topic);
        }
    }

//    @Override
//    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
//        if (holder.itemView instanceof RecyclerView) {
//            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
//            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
//            int position = manager.findFirstVisibleItemPosition();
//            View view = manager.findViewByPosition(position);
//            ViewGroup.MarginLayoutParams lp =
//                    (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//            if (view != null) {
//                xOffset = view.getLeft() - lp.leftMargin; //如果你设置了margin则减去
//            }
//        }
//        super.onViewDetachedFromWindow(holder);
//    }
//
//    @Override
//    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//        if (holder.itemView instanceof RecyclerView) {
//            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
//            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
//            manager.scrollToPositionWithOffset(position, xOffset);
//        }
//    }
}

