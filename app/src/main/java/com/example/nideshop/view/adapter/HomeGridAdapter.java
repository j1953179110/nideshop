package com.example.nideshop.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.nideshop.R;
import com.example.nideshop.bean.HomeBean;

import java.util.ArrayList;

public class HomeGridAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;
    private GridLayoutHelper gridLayoutHelper;

    public HomeGridAdapter(Context context, ArrayList<HomeBean.DataBean.BrandListBean> brandlist, GridLayoutHelper gridLayoutHelper) {
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
        return new GirdViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class GirdViewHolder extends RecyclerView.ViewHolder {
        public GirdViewHolder(View inflate) {
            super(inflate);
        }
    }
}
