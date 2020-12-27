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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nideshop.R;
import com.example.nideshop.bean.HomeBean;

import java.util.ArrayList;

public class HomeSingleLayoutAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;
    private GridLayoutHelper gridLayoutHelper;

    public HomeSingleLayoutAdapter(Context context, ArrayList<HomeBean.DataBean.BrandListBean> brandlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.brandlist = brandlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_brand, parent, false);
        return new GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.BrandListBean brandListBean = brandlist.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(gridViewHolder.iv_brand);
        gridViewHolder.tv_name.setText(brandListBean.getName());
        gridViewHolder.tv_price.setText(brandListBean.getFloor_price() + "元起");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_brand;
        TextView tv_name;
        TextView tv_price;

        public GridViewHolder(View inflate) {
            super(inflate);
            iv_brand = inflate.findViewById(R.id.iv_brand);
            tv_name = inflate.findViewById(R.id.tv_name);
            tv_price = inflate.findViewById(R.id.tv_price);
        }
    }
}
