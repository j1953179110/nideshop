package com.example.nideshop.view.adapter;

import android.content.Context;
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
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HotLinearAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotgoodlist;
    private LinearLayoutHelper linearLayoutHelper;


    public HotLinearAdapter(Context context, ArrayList<HomeBean.DataBean.HotGoodsListBean> hotgoodlist, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.hotgoodlist = hotgoodlist;
        this.linearLayoutHelper = linearLayoutHelper;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_hotgood, parent, false);
        return new HotViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.HotGoodsListBean hotGoodsListBean = hotgoodlist.get(position);
        HotViewHolder hotViewHolder = (HotViewHolder) holder;
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(hotViewHolder.iv_hotgood);
        hotViewHolder.tv_hot_name.setText(hotGoodsListBean.getName());
        hotViewHolder.tv_hot_brief.setText(hotGoodsListBean.getGoods_brief());
        hotViewHolder.tv_hot_price.setText("￥"+hotGoodsListBean.getRetail_price());


    }

    @Override
    public int getItemCount() {
        return 3;
    }


    private class HotViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_hotgood;
        TextView tv_hot_name;
        TextView tv_hot_brief;
        TextView tv_hot_price;

        public HotViewHolder(View inflate) {
            super(inflate);
            iv_hotgood = inflate.findViewById(R.id.iv_hotgood);
            tv_hot_name = inflate.findViewById(R.id.tv_hot_name);
            tv_hot_brief = inflate.findViewById(R.id.tv_hot_brief);
            tv_hot_price = inflate.findViewById(R.id.tv_hot_price);

        }
    }
}
