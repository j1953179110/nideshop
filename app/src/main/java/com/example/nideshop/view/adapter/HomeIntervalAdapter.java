package com.example.nideshop.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.nideshop.R;

public class HomeIntervalAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private String string;
    private LinearLayoutHelper linearLayoutHelper;

    public HomeIntervalAdapter(Context context, String string, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.string = string;
        this.linearLayoutHelper = linearLayoutHelper;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_interval, parent,false);
        return new LinearViewHolder(inflate);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinearViewHolder linearViewHolder = (LinearViewHolder) holder;
        linearViewHolder.tv_interval.setText(string);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class LinearViewHolder extends RecyclerView.ViewHolder {
        TextView tv_interval;

        public LinearViewHolder(View inflate) {
            super(inflate);
            tv_interval = inflate.findViewById(R.id.tv_interval);
        }
    }
}
