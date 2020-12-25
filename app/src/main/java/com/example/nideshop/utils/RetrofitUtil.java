package com.example.nideshop.utils;

public class RetrofitUtil {
    public static RetrofitUtil instance;

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }


}
