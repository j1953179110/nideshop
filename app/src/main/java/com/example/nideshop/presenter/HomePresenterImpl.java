package com.example.nideshop.presenter;

import com.example.nideshop.base.BasePresenter;
import com.example.nideshop.bean.HomeBean;
import com.example.nideshop.interfaces.HomeContract;
import com.example.nideshop.interfaces.ICallBack;
import com.example.nideshop.model.HomeModelImpl;
import com.example.nideshop.utils.URLContract;

public class HomePresenterImpl extends BasePresenter<HomeContract.IHomeView, HomeContract.HomeModel> implements HomeContract.HomePresenter {

    @Override
    public void getHome() {
        iModel.getHome(URLContract.HomeList, new ICallBack<HomeBean>() {
            @Override
            public void Success(HomeBean homeBean) {
                iView.getHomeReturn(homeBean);
            }

            @Override
            public void Fail(String error) {

            }
        });
    }

    @Override
    protected HomeContract.HomeModel getModel() {
        return new HomeModelImpl();
    }
}
