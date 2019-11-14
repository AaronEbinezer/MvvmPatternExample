package com.example.mvvmpatterneg.api;

import com.example.mvvmpatterneg.model.GetAllInfoDetail;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/values/getallinfo")
    public Single<GetAllInfoDetail> getProductDetail();
}
