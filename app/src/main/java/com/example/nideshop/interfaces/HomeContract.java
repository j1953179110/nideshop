package com.example.nideshop.interfaces;

import com.example.nideshop.base.BaseModel;
import com.example.nideshop.base.BaseView;
import com.example.nideshop.bean.HomeBean;

public class HomeContract {

    public interface IHomeView extends BaseView {
        void getHomeReturn(HomeBean home);
    }

    public interface HomePresenter {
        void getHome();
    }

    public interface HomeModel extends BaseModel {
        <T> void getHome(String url, ICallBack<T> iCallBack);
    }
}
