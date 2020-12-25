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

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.nideshop.R;
import com.example.nideshop.base.BaseFragment;
import com.example.nideshop.base.BasePresenter;
import com.example.nideshop.bean.HomeBean;
import com.example.nideshop.interfaces.HomeContract;
import com.example.nideshop.presenter.HomePresenterImpl;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.IHomeView {

    private Button et_search;
    private RecyclerView rv_home;

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

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        rv_home.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        rv_home.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        linearLayoutHelper.setItemCount(2);
        linearLayoutHelper.setMarginTop(5);
        linearLayoutHelper.setMarginBottom(5);
        linearLayoutHelper.setBgColor(Color.WHITE);

        
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
        if(home != null){
            Log.d("TAG","请求成功");
        }else{
            Log.d("TAG","请求失败");
        }
    }
}