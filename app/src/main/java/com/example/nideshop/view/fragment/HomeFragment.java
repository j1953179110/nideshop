package com.example.nideshop.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.nideshop.R;
import com.example.nideshop.base.BaseFragment;
import com.example.nideshop.base.BasePresenter;
import com.example.nideshop.bean.HomeBean;
import com.example.nideshop.interfaces.HomeContract;
import com.example.nideshop.presenter.HomePresenterImpl;
import com.example.nideshop.view.adapter.HomeLinearAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.IHomeView {

    private Button et_search;
    private RecyclerView rv_home;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        presenter.getHome();
    }

    @Override
    protected void initView(View inflate) {
        et_search = (Button) inflate.findViewById(R.id.et_search);
        rv_home = (RecyclerView) inflate.findViewById(R.id.rv_home);

        bannerlist = new ArrayList<>();
        channellist = new ArrayList<>();
        brandlist = new ArrayList<>();
    }

    public void initAdapter() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        rv_home.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        rv_home.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        linearLayoutHelper.setItemCount(2);
        linearLayoutHelper.setBgColor(Color.WHITE);

        HomeLinearAdapter homeLinearAdapter = new HomeLinearAdapter(getActivity(), bannerlist, channellist, linearLayoutHelper);

        new GridLayoutHelper()



        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        delegateAdapter.addAdapter(homeLinearAdapter);

        rv_home.setLayoutManager(layoutManager);
        rv_home.setAdapter(delegateAdapter);
    }

    @Override
    protected HomePresenterImpl createPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public void getHomeReturn(HomeBean home) {
        if (home != null) {
            List<HomeBean.DataBean.BannerBean> banner = home.getData().getBanner();
            this.bannerlist.addAll(banner);
            List<HomeBean.DataBean.ChannelBean> channel = home.getData().getChannel();
            this.channellist.addAll(channel);
            List<HomeBean.DataBean.BrandListBean> brandList = home.getData().getBrandList();
            this.brandlist.addAll(brandList);
            initAdapter();
        } else {
            Log.d("TAG", "请求失败");
        }
    }
}