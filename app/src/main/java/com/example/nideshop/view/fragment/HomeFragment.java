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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.nideshop.R;
import com.example.nideshop.base.BaseFragment;
import com.example.nideshop.base.BasePresenter;
import com.example.nideshop.bean.HomeBean;
import com.example.nideshop.interfaces.HomeContract;
import com.example.nideshop.presenter.HomePresenterImpl;
import com.example.nideshop.view.adapter.HomeGridAdapter;
import com.example.nideshop.view.adapter.HomeIntervalAdapter;
import com.example.nideshop.view.adapter.HomeLinearAdapter;
import com.example.nideshop.view.adapter.HomeMonDayGridAdapter;
import com.example.nideshop.view.adapter.HotLinearAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.IHomeView {

    private Button et_search;
    private RecyclerView rv_home;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newgoodlist;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotgoodlist;


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
        newgoodlist = new ArrayList<>();
        hotgoodlist = new ArrayList<>();
    }

    public void initAdapter() {
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        rv_home.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        rv_home.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        //banner+interval
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(2);
        linearLayoutHelper.setBgColor(Color.WHITE);
        HomeLinearAdapter homeLinearAdapter = new HomeLinearAdapter(getActivity(), bannerlist, channellist, linearLayoutHelper);

        //品牌供应商直供
        LinearLayoutHelper linearHelper = new LinearLayoutHelper();
        linearHelper.setItemCount(1);
        linearHelper.setMarginTop(20);
        linearHelper.setBgColor(Color.WHITE);
        HomeIntervalAdapter intervalAdapter = new HomeIntervalAdapter(getActivity(), "品牌供应商直供", linearHelper);

        //brand
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(1);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(1);// 控制子元素之间的水平间距
        gridLayoutHelper.setBgColor(Color.WHITE);
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        HomeGridAdapter homeGridAdapter = new HomeGridAdapter(getActivity(), brandlist, gridLayoutHelper);

        //周一周四新品首发
        LinearLayoutHelper MondayHelper = new LinearLayoutHelper();
        MondayHelper.setItemCount(1);
        MondayHelper.setBgColor(Color.WHITE);
        HomeIntervalAdapter MondayAdapter = new HomeIntervalAdapter(getActivity(), "周一周四·新品首发", MondayHelper);

        //newgood
        GridLayoutHelper newGoodGridHelper = new GridLayoutHelper(2);
        // 公共属性
        newGoodGridHelper.setItemCount(4);// 设置布局里Item个数
        // gridLayoutHelper特有属性（下面会详细说明）
        newGoodGridHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        newGoodGridHelper.setVGap(1);// 控制子元素之间的垂直间距
        newGoodGridHelper.setPaddingBottom(50);
        newGoodGridHelper.setHGap(1);// 控制子元素之间的水平间距
        newGoodGridHelper.setBgColor(Color.WHITE);
        newGoodGridHelper.setSpanCount(2);// 设置每行多少个网格
        HomeMonDayGridAdapter homeNewGoodGridAdapter = new HomeMonDayGridAdapter(getActivity(), newgoodlist, newGoodGridHelper);

        //人气推荐
        LinearLayoutHelper HosIntervaltLayoutHelper = new LinearLayoutHelper();
        HosIntervaltLayoutHelper.setItemCount(1);
        HosIntervaltLayoutHelper.setMarginTop(20);
        HosIntervaltLayoutHelper.setBgColor(Color.WHITE);
        HomeIntervalAdapter HostAdapter = new HomeIntervalAdapter(getActivity(), "人气推荐", HosIntervaltLayoutHelper);

        //HotGood
        LinearLayoutHelper HostlinearLayoutHelper = new LinearLayoutHelper();
        HostlinearLayoutHelper.setItemCount(3);
        HostlinearLayoutHelper.setBgColor(Color.WHITE);
        HotLinearAdapter HostLinearAdapter = new HotLinearAdapter(getActivity(), hotgoodlist, HostlinearLayoutHelper);

        //专题精选
        LinearLayoutHelper choicenessIntervaltLayoutHelper = new LinearLayoutHelper();
        choicenessIntervaltLayoutHelper.setItemCount(1);
        choicenessIntervaltLayoutHelper.setMarginTop(20);
        choicenessIntervaltLayoutHelper.setBgColor(Color.WHITE);
        HomeIntervalAdapter choicenesstAdapter = new HomeIntervalAdapter(getActivity(), "专题精选", choicenessIntervaltLayoutHelper);

        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setBgColor(Color.WHITE);
        HomeSingleLayoutAdapter singleLayoutHelper = new HomeSingleLayoutAdapter(getActivity(), "专题精选", singleLayoutHelper);


        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        delegateAdapter.addAdapter(homeLinearAdapter);
        delegateAdapter.addAdapter(intervalAdapter);
        delegateAdapter.addAdapter(homeGridAdapter);
        delegateAdapter.addAdapter(MondayAdapter);
        delegateAdapter.addAdapter(homeNewGoodGridAdapter);
        delegateAdapter.addAdapter(HostAdapter);
        delegateAdapter.addAdapter(HostLinearAdapter);
        delegateAdapter.addAdapter(choicenesstAdapter);

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
            List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = home.getData().getNewGoodsList();
            this.newgoodlist.addAll(newGoodsList);
            List<HomeBean.DataBean.HotGoodsListBean> hotgoodlist = home.getData().getHotGoodsList();
            this.hotgoodlist.addAll(hotgoodlist);

            initAdapter();
        } else {
            Log.d("TAG", "请求失败");
        }
    }
}