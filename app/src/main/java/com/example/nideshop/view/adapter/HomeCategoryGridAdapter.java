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

public class HomeCategoryGridAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodlist;
    private GridLayoutHelper gridLayoutHelper;

    public HomeCategoryGridAdapter(Context context, ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.goodlist = goodlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_goodlist, parent, false);
        return new GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        HomeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodlist.get(position);
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(gridViewHolder.iv_goodlist);
        gridViewHolder.tv_listname.setText(goodsListBean.getName());
        gridViewHolder.tv_listprice.setText("￥"+goodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_goodlist;
        TextView tv_listname;
        TextView tv_listprice;

        public GridViewHolder(View inflate) {
            super(inflate);
            iv_goodlist = inflate.findViewById(R.id.iv_goodlist);
            tv_listname = inflate.findViewById(R.id.tv_listname);
            tv_listprice = inflate.findViewById(R.id.tv_listprice);
        }
    }
}
