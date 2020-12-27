package com.example.nideshop.view.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nideshop.R;
import com.example.nideshop.bean.HomeBean;

import java.util.ArrayList;

public class TopicAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topiclist;
    private LinearLayoutHelper linearLayoutHelper;

    public TopicAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topiclist, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.topiclist = topiclist;
        this.linearLayoutHelper = linearLayoutHelper;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_toplist, parent, false);
        return new TopViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopViewHolder topViewHolder = (TopViewHolder) holder;
        HomeBean.DataBean.TopicListBean topicListBean = topiclist.get(position);
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(topViewHolder.iv_topic);
        topViewHolder.tv_top_title.setText(topicListBean.getTitle());
        topViewHolder.tv_top_price.setText("￥" + topicListBean.getPrice_info() + "元起");
        topViewHolder.tv_top_subtitle.setText(topicListBean.getSubtitle());

    }

    @Override
    public int getItemCount() {
        return topiclist.size();
    }

    private class TopViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_topic;
        TextView tv_top_title;
        TextView tv_top_subtitle;
        TextView tv_top_price;

        public TopViewHolder(View inflate) {
            super(inflate);
            iv_topic = inflate.findViewById(R.id.iv_topic);
            tv_top_title = inflate.findViewById(R.id.tv_top_title);
            tv_top_subtitle = inflate.findViewById(R.id.tv_top_subtitle);
            tv_top_price = inflate.findViewById(R.id.tv_top_price);
        }
    }
}
/* TopViewHolder topViewHolder = (TopViewHolder) holder;


        ImageView iv_topic = itemView.findViewById(R.id.iv_topic);
        TextView tv_top_title = itemView.findViewById(R.id.tv_top_title);
        TextView tv_top_price = itemView.findViewById(R.id.tv_top_price);
        TextView tv_top_subtitle = itemView.findViewById(R.id.tv_top_subtitle);*/
