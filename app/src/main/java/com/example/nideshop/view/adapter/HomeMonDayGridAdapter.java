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

public class HomeMonDayGridAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newgoodlist;
    private GridLayoutHelper gridLayoutHelper;

    public HomeMonDayGridAdapter(Context context, ArrayList<HomeBean.DataBean.NewGoodsListBean> newgoodlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.newgoodlist = newgoodlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_newgood, parent, false);
        return new GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.NewGoodsListBean newGoodsListBean = newgoodlist.get(position);
        GridViewHolder gridViewHolder = (GridViewHolder) holder;
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(gridViewHolder.tv_newgood);
        gridViewHolder.tv_goodname.setText(newGoodsListBean.getName());
        gridViewHolder.tv_goodprice.setText("￥" + newGoodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_newgood;
        TextView tv_goodname;
        TextView tv_goodprice;

        public GridViewHolder(View inflate) {
            super(inflate);
            tv_newgood = inflate.findViewById(R.id.iv_newgood);
            tv_goodname = inflate.findViewById(R.id.tv_goodname);
            tv_goodprice = inflate.findViewById(R.id.tv_goodprice);
        }
    }
}
