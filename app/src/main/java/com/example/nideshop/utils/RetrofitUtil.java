package com.example.nideshop.utils;

import com.example.nideshop.api.HomeApiservice;
import com.example.nideshop.interfaces.ICallBack;
import com.example.nideshop.interfaces.INetWorkInterface;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtil implements INetWorkInterface {
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

    private HomeApiservice apiservice;

    public RetrofitUtil() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLContract.BASE_RRL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiservice = retrofit.create(HomeApiservice.class);
    }

    @Override
    public <T> void get(String url, ICallBack<T> iCallBack) {
        apiservice
                .getBanner(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = iCallBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            Gson gson = new Gson();
                            T json = gson.fromJson(string, actualTypeArgument);
                            iCallBack.Success(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
