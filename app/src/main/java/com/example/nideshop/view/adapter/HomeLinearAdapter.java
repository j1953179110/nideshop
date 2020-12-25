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

public class HomeLinearAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private LinearLayoutHelper linearLayoutHelper;

    private static final int BANNER = 0;
    private static final int CHANNEL = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else {
            return CHANNEL;
        }
    }

    public HomeLinearAdapter(Context context, ArrayList<HomeBean.DataBean.BannerBean> bannerlist, ArrayList<HomeBean.DataBean.ChannelBean> channellist, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.bannerlist = bannerlist;
        this.channellist = channellist;
        this.linearLayoutHelper = linearLayoutHelper;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner, parent, false);
            return new BannerViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_channel, parent, false);
            return new ChannelViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataBean.BannerBean bannerBean = (HomeBean.DataBean.BannerBean) path;
                        String image_url = bannerBean.getImage_url();
                        Glide.with(context).load(image_url).into(imageView);
                    }
                }).start();
                break;
            case CHANNEL:
                ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
                Glide.with(context).load(channellist.get(0).getIcon_url()).into(channelViewHolder.iv_jujia);
                channelViewHolder.tv_jujia.setText(channellist.get(0).getName());
                Glide.with(context).load(channellist.get(1).getIcon_url()).into(channelViewHolder.iv_canchu);
                channelViewHolder.tv_canchu.setText(channellist.get(1).getName());
                Glide.with(context).load(channellist.get(2).getIcon_url()).into(channelViewHolder.iv_peijian);
                channelViewHolder.tv_peijian.setText(channellist.get(2).getName());
                Glide.with(context).load(channellist.get(3).getIcon_url()).into(channelViewHolder.iv_fuzhuang);
                channelViewHolder.tv_fuzhuang.setText(channellist.get(3).getName());
                Glide.with(context).load(channellist.get(4).getIcon_url()).into(channelViewHolder.iv_zhiqu);
                channelViewHolder.tv_zhiqu.setText(channellist.get(4).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public BannerViewHolder(View inflate) {
            super(inflate);
            banner = inflate.findViewById(R.id.banner);
        }
    }

    private class ChannelViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_jujia;
        ImageView iv_canchu;
        ImageView iv_peijian;
        ImageView iv_fuzhuang;
        ImageView iv_zhiqu;
        TextView tv_jujia;
        TextView tv_canchu;
        TextView tv_peijian;
        TextView tv_fuzhuang;
        TextView tv_zhiqu;

        public ChannelViewHolder(View inflate) {
            super(inflate);
            iv_jujia = inflate.findViewById(R.id.iv_jujia);
            iv_canchu = inflate.findViewById(R.id.iv_canchu);
            iv_peijian = inflate.findViewById(R.id.iv_peijian);
            iv_fuzhuang = inflate.findViewById(R.id.iv_fuzhuang);
            iv_zhiqu = inflate.findViewById(R.id.iv_zhiqu);
            tv_jujia = inflate.findViewById(R.id.tv_jujia);
            tv_canchu = inflate.findViewById(R.id.tv_canchu);
            tv_peijian = inflate.findViewById(R.id.tv_peijian);
            tv_fuzhuang = inflate.findViewById(R.id.tv_fuzhuang);
            tv_zhiqu = inflate.findViewById(R.id.tv_zhiqu);
        }
    }
}
