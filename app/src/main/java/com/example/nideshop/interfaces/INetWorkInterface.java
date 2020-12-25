package com.example.nideshop.interfaces;

public
interface INetWorkInterface {
    public <T> void get(String url, ICallBack<T> iCallBack);
}
