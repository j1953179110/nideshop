package com.example.nideshop.interfaces;

import com.example.nideshop.bean.HomeBean;

public interface ICallBack<T> {
    void Success(T t);

    void Fail(String error);
}
