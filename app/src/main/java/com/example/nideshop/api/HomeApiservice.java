package com.example.nideshop.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HomeApiservice {

    @GET
    Observable<ResponseBody> getBanner(@Url String url);
}
