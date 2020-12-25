package com.example.nideshop.model;

import com.example.nideshop.interfaces.HomeContract;
import com.example.nideshop.interfaces.ICallBack;
import com.example.nideshop.utils.RetrofitUtil;

public class HomeModelImpl implements HomeContract.HomeModel {

    @Override
    public <T> void getHome(String url, ICallBack<T> iCallBack) {
        RetrofitUtil.getInstance().get(url, iCallBack);
    }
}
